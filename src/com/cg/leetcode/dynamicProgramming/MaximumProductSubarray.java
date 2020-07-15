package com.cg.leetcode.dynamicProgramming;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(maxProduct(new int[] { 5 }));
	}

	/*
	 * ��¼���ֽ�����������
	 */
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxProduct = nums[0];
		int positive = nums[0];
		int negative = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int a = positive * nums[i];
			int b = negative * nums[i];// ֱ���ж�ÿ���۳˵Ľ��
			positive = Math.max(Math.max(a, b), nums[i]);
			negative = Math.min(Math.min(a, b), nums[i]);
			maxProduct = Math.max(maxProduct, positive);
		}
		return maxProduct;
	}
}
