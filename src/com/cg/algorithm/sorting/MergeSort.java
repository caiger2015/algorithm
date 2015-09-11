package com.cg.algorithm.sorting;

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
	 * @author caigen
	 * @created 2015年5月14日 下午10:35:17
	 * @param a
	 * @see com.cg.algorithm.sorting.ISort#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int begin = 0, end = a.length - 1;
		mergeSort(a, begin, end);
	}

	/**
	 * Description: 递归调用进行分组
	 * 
	 * @param a
	 *            要排序的数组
	 * @param b
	 *            辅助数组
	 * @param begin
	 *            子数组开始
	 * @param end
	 *            子数组结尾
	 */
	private void mergeSort(int[] a, int begin, int end) {
		if (begin >= end)
			return;
		int mid = (begin + end) / 2;
		mergeSort(a, begin, mid);
		mergeSort(a, mid + 1, end);
		merge(a, begin, mid, end);
	}

	/**
	 * Description: 利用辅助数组合并两个子数组
	 * 
	 * @param a
	 *            要排序的数组
	 * @param b
	 *            辅助数组
	 * @param begin
	 *            第一个子数组开始
	 * @param mid
	 *            第一个子数组结尾
	 * @param end
	 *            第二个子数组结尾
	 */
	private void merge(int[] a, int begin, int mid, int end) {
		if (begin >= end)
			return;
		int i = begin, j = mid + 1, k = 0, b[] = new int[end - begin + 1];
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else if (a[i] > a[j]) {
				b[k++] = a[j++];
			}
		}
		// 处理剩下的元素
		while (i <= mid)
			b[k++] = a[i++];
		while (j <= end)
			b[k++] = a[j++];
		// 将b中元素添加到a中
		for (int m = 0; m <= end - begin; m++) {
			a[begin + m] = b[m];
		}
	}

}
