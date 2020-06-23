package com.cg.algorithm.sorting;

/**
 * Title: Sort.java Description: 排序算法的接口
 * 
 * @author caigen
 * @created 2015年5月14日 下午8:35:11
 */
@FunctionalInterface
public interface ISort {
	public void sort(int[] a);

	/**
	 * Description:
	 * 
	 * @param a
	 */

	default void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
