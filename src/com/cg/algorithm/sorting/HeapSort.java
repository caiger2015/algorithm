package com.cg.algorithm.sorting;

import java.util.Arrays;

/**
 * Title: heapSort.java Description:
 *
 * @author caigen
 * @created 2015年5月15日 下午8:52:22
 */

public class HeapSort implements ISort {

    /**
     * Description:堆排序算法，调整成堆O(logn ),总时间复杂度O(nlogn)
     *
     * @param a
     * @author caigen
     * @created 2015年5月15日 下午8:52:22
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    // 堆是完全二叉树
    // 把n个元素的数组看成堆的层遍历，第i个元素有一下性质：
    // i=0，则i为根节点；
    // 若2i+1<n，则2i+1为它的左孩子，若2i+2<n，则为i的右孩子
    // 它的父节点为(i-1)/2
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        // 先把数组排成最大堆：从最后一个元素n-1的父节点（深度最深的子树）开始，从后往前遍历所有的非零度节点排成最大堆
        int n = a.length;
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            sift(a, i, n - 1);
        }
        // 每次去除第一个最大的元素放在末尾，然后把剩下的元素再排成最大堆
        for (int j = n - 1; j > 0; j--) {
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            sift(a, 0, j - 1);
        }
    }

    /**
     * Description: 将根节点为begin的子数组排成最大堆，根节点为要插入的元素
     *
     * @param a     要排序的数组
     * @param begin 堆中要插入的元素，为子树的根节点
     * @param end   堆的最后一个元素
     */
    private void sift(int[] a, int begin, int end) {
        int i = begin, j = 2 * i + 1;
        int temp = a[i];
        while (j <= end) {
            // 比较左右结点大小，保证平衡性
            if (j < end && a[j] < a[j + 1]) {
                j++;
            }
            if (temp < a[j]) {
                a[i] = a[j];
                // 待插入元素到达位置j
                i = j;
                j = 2 * j + 1;
            } else {
                break;
            }
        }
        a[i] = temp;
    }

	/**
	 * 默认最大值在上，根结点为堆中最大元素，子树也是这样
	 * 性质：二叉堆是一组能够堆有序的完全二叉树排序的元素，在数组中按照层级存储（不使用数组的第一个位置0，为了更好地利用性质）
	 * 第i个节点（根结点是第一个节点）的父节点为i/2，左子结点2i，右子结点2i+1
	 * 先构造最大堆，然后每次取出根结点交换末尾结点，移除末尾节点后恢复最大堆结构，直到堆空。
	 * @param a
	 */
	public void heapSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int n = a.length - 1;
		//从最后一个非叶子结点开始下沉，构造最大堆，完成后a[1]为最大元素
		for (int k = n / 2; k >= 1; k--) {
			sink(a, k, n);
		}
		for (int i = n; i > 1; i--) {
			swap(a, i, 1);
			sink(a, 1, i-1);
		}
	}

	/**
	 * 从叶子结点上浮，用于从末端新增元素
	 * @param a
	 * @param k
	 */
	public void swim(int[] a, int k) {
		while (k > 1 && a[k] > a[k / 2]) {
			swap(a, k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * 从根结点下沉元素，删除节点时，用末尾节点替换删除节点然后下沉
	 *
	 * @param a 二叉堆对应的数组，a[0]为空，从a[1]开始
	 * @param k 带下沉的节点
	 * @param n 堆中最后一个节点
	 */
	public void sink(int[] a, int k, int n) {
		//边界是n，最后一个节点也要比较
		while (2 * k <= n) {
			int j = 2 * k;
			//判断j<n，否则会越界
			if (j < n && a[j + 1] > a[j]) {
				j++;
			}
			if (a[k] >= a[j]) {
				break;
			}
			swap(a, k, j);
			k = j;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 6, 4, 3, 1, 7, 9, 4, 3, 2, 1};
		new HeapSort().heapSort(a);
		System.out.println(Arrays.toString(a));
	}


}
