/**
 * 
 */
package com.cg.leetcode.math;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number. The digits are stored such that the most significant digit is at
 * the head of the list.
 * 
 * @author caiger
 */
public class PlusOne {

	public static void main(String[] args) {

	}

	public int[] plusOne(int[] A) {
		if (A == null || A.length == 0)
			return A;
		int index = A.length - 1;
		// һλdigit����9ʱ+1��λ������0
		while (index >= 0 && A[index] == 9) {
			A[index] = 0;
			index--;
		}
		// ���λû�н�λʱ���ڵ�һ��С��9��λ+1���ء�
		if (index >= 0) {
			A[index]++;
			return A;
		}
		// ���λ�н�λʱ��ֻ����ÿһλ����9����99999����Ҫnewһ���µ����飬��λΪ1������Ϊ0.
		else {
			int[] B = new int[A.length + 1];
			B[0] = 1;
			for (int i = 1; i < B.length; i++)
				B[i] = 0;
			return B;
		}
	}
}
