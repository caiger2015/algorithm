package com.cg.algorithm.sorting;

import java.util.Arrays;

/**
 * Title: MergeSort.java Description:
 *
 * @author caigen
 * @created 2015年5月14日 下午10:35:17
 */

public class MergeSort implements ISort {

    /**
     * Description:归并排序算法，时间复杂度O(nlogn)~O(n^2),空间复杂度：O(n),稳定的
     *
     * @param a
     * @author caigen
     * @created 2015年5月14日 下午10:35:17
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
			return;
		}
        int begin = 0, end = a.length - 1;
        mergeSort(a, begin, end);
    }

    /**
     * Description: 递归调用进行分组，自顶向下
     *
     * @param a     要排序的数组
     * @param begin 子数组开始
     * @param end   子数组结尾
     */
    private void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) {
			return;
		}
        int mid = (begin + end) / 2;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);
    }

    /**
     * Description: 利用辅助数组合并两个子数组
     *
     * @param a     要排序的数组
     * @param begin 第一个子数组开始
     * @param mid   第一个子数组结尾
     * @param end   第二个子数组结尾
     */
    private static void merge(int[] a, int begin, int mid, int end) {
		if (begin >= end || end > a.length) {
			return;
		}
        int i = begin, j = mid + 1, k = 0, b[] = new int[end - begin + 1];
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        // 处理剩下的元素
        while (i <= mid) {
			b[k++] = a[i++];
		}
        while (j <= end) {
			b[k++] = a[j++];
		}
        // 将b中元素添加到a中
        for (int m = 0; m <= end - begin; m++) {
            a[begin + m] = b[m];
        }
    }

	/**
	 * 用2^n控制数组下标实现分组，自底向上
	 * @param a
	 */
	public static void mergeSortWithLoop(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int n = a.length;
		for (int d = 1; d < n; d <<= 1) {
			//每次取相邻的两组进行合并
			for (int i = 0; i < n; i += (d * 2)) {
				int hi = Math.min(i + d * 2 - 1, n - 1);
				//找出merge函数的参数，判断边界
				merge(a, i, i + d - 1, hi);
			}
		}
	}



	public static void main(String[] args) {
		int[] a = new int[]{8, 7, 6, 6, 6, 7, 8, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(a));
	}

}
