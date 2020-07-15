/*
 * There are two sorted arrays A and B of size m and n respectively.
 *  Find the median of the two sorted arrays. 
 *  The overall run time complexity should be O(log (m+n)).
 *  @caiger
 */
package com.cg.leetcode.divideAndConquer;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(findMedianSortedArrays(new int[] { 1, 4, 5, 6, 9 },
				new int[] { 2, 3, 7, 8 }));
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int n = B.length;
		int m = A.length;
		if ((m + n) % 2 == 1) {
			return findKth(A, m, B, n, (m + n) / 2 + 1);
		} else {
			return (findKth(A, m, B, n, (m + n) / 2) + findKth(A, m, B, n,
					(m + n) / 2 + 1)) / 2;
		}
	}

	/*
	 * 分治法：转化为若干个子问题：在两个sorted的数列中，查找合并排序后第K个数的问题，由对称性可以假设A长度小于B来设计算法
	 * 1.边界条件（重点先考虑的）:有一个空，直接返回另一个的第K个（这里的K是递归里的）； k<= 1时，返回此时比较的两个数中小的那个
	 * 若比较的两个相等，说明刚好合并之后是第k个，返回其中一个 2.问题转化（递归）：更新递归函数的参数
	 * 
	 * @param A B 是查找的数组
	 * 
	 * @param m n 是它俩的长度
	 * 
	 * @param k 是要找的第k个数
	 */
	public static double findKth(int[] A, int m, int[] B, int n, int k) {
		// 总是设定m<= n,对于对称性的问题可以转化为只考虑一种情况的
		if (m > n)
			return findKth(B, n, A, m, k);
		if (m == 0)
			return B[k - 1];
		if (k <= 1)
			return Math.min(A[0], B[0]);
		int pa = Math.min(k / 2, m);
		int pb = k - pa;
		if (A[pa - 1] < B[pb - 1]) {
			int[] AA = new int[m - pa];
			for (int i = 0; i < m - pa; i++) {
				AA[i] = A[pa + i];
			}
			return findKth(AA, m - pa, B, n, k - pa);
		} else if (A[pa - 1] > B[pb - 1]) {
			int[] BB = new int[n - pb];
			for (int i = 0; i < n - pb; i++) {
				BB[i] = B[pb + i];
			}
			return findKth(A, m, BB, n - pb, k - pb);
		} else {
			return A[pa - 1];
		}
	}

	/*
	 * 自己写的片面的方法，不完善，没考虑重复，没考虑中位数定义 没考虑奇偶的情况
	 */
	public static int findMedianSortedArrays1(int A[], int B[]) {
		int k = (A.length + B.length) / 2;
		int al = 0, bl = 0;
		int ar = k - 1;
		int br = k - 1;
		if (A.length < k) {
			ar = A.length;
		}
		if (B.length < k)
			br = B.length;
		int a = (ar + al) / 2;
		int b = (br + bl) / 2;
		while (k >= 0 && ar > al && br > bl) {
			a = (ar + al) / 2;
			b = (br + bl) / 2;
			if (A[a] > B[b]) {
				bl = b + 1;
				k -= (b - bl + 1);
			} else {
				k -= (a - al + 1);
				al = a + 1;
			}
		}
		if (al > ar) {
			return B[k];
		}
		if (bl > br) {
			return A[k];
		}
		return A[a] > B[b] ? B[b] : A[a];
	}
}
