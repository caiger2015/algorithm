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
	 * ���η���ת��Ϊ���ɸ������⣺������sorted�������У����Һϲ�������K���������⣬�ɶԳ��Կ��Լ���A����С��B������㷨
	 * 1.�߽��������ص��ȿ��ǵģ�:��һ���գ�ֱ�ӷ�����һ���ĵ�K���������K�ǵݹ���ģ��� k<= 1ʱ�����ش�ʱ�Ƚϵ���������С���Ǹ�
	 * ���Ƚϵ�������ȣ�˵���պúϲ�֮���ǵ�k������������һ�� 2.����ת�����ݹ飩�����µݹ麯���Ĳ���
	 * 
	 * @param A B �ǲ��ҵ�����
	 * 
	 * @param m n �������ĳ���
	 * 
	 * @param k ��Ҫ�ҵĵ�k����
	 */
	public static double findKth(int[] A, int m, int[] B, int n, int k) {
		// �����趨m<= n,���ڶԳ��Ե��������ת��Ϊֻ����һ�������
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
	 * �Լ�д��Ƭ��ķ����������ƣ�û�����ظ���û������λ������ û������ż�����
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
