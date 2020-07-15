/**
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution
 */
package com.cg.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @author caiger
 *
 */
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		// 用来控制第一次对res赋值
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < len; i++) {
			int j = i + 1, k = len - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(target - sum);
				if (diff == 0)
					return target;
				if (min > diff) {
					res = sum;
					min = diff;
				}
				if (target > sum)
					j++;
				else {
					k--;
				}
			}
		}
		return res;
	}
}
