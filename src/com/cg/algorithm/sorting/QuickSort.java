package com.cg.algorithm.sorting;

import java.util.Arrays;

public class QuickSort implements ISort {
    public QuickSort() {
    }

    /**
     * Description:快速排序算法
	 * 时间复杂度O(nlogn)
	 * 不稳定的
     *
     * @param a
     * @author caigen
     * @created 2015年5月14日 下午8:39:52
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int begin = 0, end = a.length - 1;
        quickSort(a, begin, end);
    }

//    /**
//     * Description:
//     *
//     * @param a     要排序的数组
//     * @param begin
//     * @param end
//     */
//    private void quickSort(int[] A, int begin, int end) {
//        if (begin >= end) {
//			return;
//		}
//        int index = partition(A, begin, end);
//        // 递归调用，每次进行partition时的begin和end都在更新
//        quickSort(A, begin, index - 1);
//        quickSort(A, index + 1, end);
//    }
//
    /**
     * Description: 找到索引为begin的元素在数组A中排序好后的位置
     *
     * @param a     目标数组
     * @param lo 开始的下标
     * @param hi   结束的下标
     * @return 返回begin对应的数组元素排序后的位置
     */
    private int partition1(int[] a, int lo, int hi) {
        int temp = a[lo];
        // 双指针逐步确定temp的最终位置，以a[lo]为哨兵
        while (lo < hi) {
        	//先从后往前找小于temp的
			while (lo < hi && a[hi] > temp) {
				hi--;
			}
			a[lo] = a[hi];
			//从前往后找大于temp的
			while (lo < hi && a[lo] <= temp) {
				lo++;
			}
			a[hi] = a[lo];
		}
        //相遇的位置即为temp最终位置
		a[lo] = temp;
		return lo;
    }

    public void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pos = partition(a, lo, hi);
        quickSort(a, lo, pos - 1);
        quickSort(a, pos + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return hi;
        }
        //双指针
        int lt = lo, gt = hi, temp = a[lo];
		while (true) {
			//跳出循环时，lt指向大于temp的位置
			while (lt < hi && a[lt] <= temp) {
				lt++;
			}
			//跳出循环时，gt指向小于temp的位置
			while (lo < gt && a[gt] > temp) {
				gt--;
			}
			//如果lt和gt相遇，跳出循环
			if (lt >= gt) {
				break;
			}
			//交换大小值
			swap(a, lt, gt);
		}
		//a[lo]在左侧，跟小于temp的交换
        swap(a, lo, gt);
        return gt;
    }

	/**
	 * 三指针快速排序，排序完成后相等的值在中间，
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public void quickSortWith3way(int[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int lt = lo, gt = hi, i = lo + 1, temp = a[lo];
		//遍历i位置元素
		while (i <= gt) {
			//小于temp的交换最左的temp值a[lt]，i++，lt++
			if (a[i] < temp) {
				swap(a, i++, lt++);
			//大于temp的交换最右端的a[gt]，gt--
			} else if (a[i] > temp) {
				swap(a, i, gt--);
			//等于temp的，i++
			} else {
				i++;
			}
		}
		//循环结束时lt是最左边的temp，gt是最右边的temp
		quickSortWith3way(a, lo, lt - 1);
		quickSortWith3way(a, gt + 1, hi);
	}


    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6, 6, 6, 7, 8, 5, 4, 3, 2, 1};
		new QuickSort().quick(a);
        System.out.println(Arrays.toString(a));
    }

	public void quick(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		quickS(a, 0, a.length - 1);
	}

	private void quickS(int[] a, int l, int r) {
		//边界条件
		if (l >= r) {
			return;
		}
		int temp = a[l];
		int i = l;
		int j = l+1;
		while (j <= r) {
			if (a[j] < temp) {
				swap(a, j, i);
				i++;
			}
			j++;
		}
		swap(a, r, i);
		quickS(a, l, i - 1);
		quickS(a, i + 1, r);
	}




}
