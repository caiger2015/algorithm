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
		// 一位digit上是9时+1进位，保留0
		while (index >= 0 && A[index] == 9) {
			A[index] = 0;
			index--;
		}
		// 最高位没有进位时，在第一个小于9的位+1返回。
		if (index >= 0) {
			A[index]++;
			return A;
		}
		// 最高位有进位时，只可能每一位都是9，如99999。需要new一个新的数组，首位为1，其他为0.
		else {
			int[] B = new int[A.length + 1];
			B[0] = 1;
			for (int i = 1; i < B.length; i++)
				B[i] = 0;
			return B;
		}
	}
}
