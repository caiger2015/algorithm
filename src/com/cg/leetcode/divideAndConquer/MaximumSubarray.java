package com.cg.leetcode.divideAndConquer;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum  =  6.
 */

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(maximumSubarray(new int[] { 2, -1, 2, 3 }));
	}

	public static int maximumSubarray(int[] nums) {
		int res = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum <= 0)
				sum = nums[i];
			else {
				sum += nums[i];
			}
			res = Math.max(sum, res);
		}
		return res;
	}

}
