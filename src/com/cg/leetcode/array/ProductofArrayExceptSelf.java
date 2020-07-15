package com.cg.leetcode.array;

import java.util.Arrays;

/**
 * @author caiger Given an array of n integers where n > 1, nums, return an
 *         array output such that output[i] is equal to the product of all the
 *         elements of nums except nums[i]. Solve it without division and in
 *         O(n).For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductofArrayExceptSelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3,
				4 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				res[i] = 1;
			else {
				res[i] = res[i - 1] * nums[i - 1];
			}
		}
		int pre = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= pre;
			pre *= nums[i];
		}
		return res;
	}
}
