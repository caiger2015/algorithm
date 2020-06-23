package com.cg.algorithm.sorting;

/**
 * Title: BubbleSort.java Description:
 *
 * @author caigen
 * @created 2015年5月14日 下午9:21:06
 */

public class BubbleSort implements ISort {

    /**
     * Description:冒泡排序
     *
     * @param a
     * @author caigen
     * @created 2015年5月14日 下午9:21:06
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
			return;
		}
        // 标记一次遍历是否有交换，没有则表示排序完成
        boolean isExchanged = true;
        for (int i = a.length - 1; i > 0 && isExchanged; i--) {
            isExchanged = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    isExchanged = true;
                }
            }
        }
    }

	public void bubbleSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		for (int i = a.length - 1; i > 0; i--) {
			boolean isSwapped = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					isSwapped = true;
					swap(a, j, j + 1);
				}
			}
			//内层无交换说明已排序
			if (!isSwapped) {
				return;
			}
		}
	}



}
