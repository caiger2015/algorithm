package com.cg.algorithm.sorting;

/**
 * Title: ShellSort.java Description:
 * 又叫缩小增量排序，是插入排序的一种，按照间隔d进行分组插入排序，每次排序之后d/2，知道d=1进行最后一次
 * 时间复杂度：O(nlogn)~O(n^2)
 * 不稳定：一次插入是稳定的，但是多次插入会改变相对位置
 * 通过二分的逻辑，减少循环中的交换次数
 *
 * @author caigen
 * @created 2015年5月14日 下午8:14:54
 */

public class ShellSort implements ISort {
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
			return;
		}
        int n = a.length;
        for (int d = n / 2; d > 0; d /= 2) {
            for (int i = d; i < n; i++) {
                int temp = a[i], j;
                for (j = i - d; j >= 0 && temp < a[j]; j -= d) {
                    a[j + d] = a[j];
                }
                a[j + d] = temp;
            }
        }
    }

	public static void shellSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
        int n = a.length;
		//执行log(N)次
        for (int d = n >> 1; d > 0; d >>= 1) {
            //每次以d为间隔分组插入a[i]，每组有n/d个成员，以d为间隔，从第二组第一个到末尾执行插入操作
            for (int i = d; i < n; i ++) {
                int temp = a[i], j = i - d;
                while (j >= 0 && a[j] > temp) {
                    a[j+d] = a[j];
                    j -= d;
                }
                a[j+d] = temp;
            }
        }
	}

    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6,6,6,7,8, 5, 4, 3, 2, 1};
        shellSort(a);
        System.out.println(a);
    }

}
