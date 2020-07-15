package com.cg.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * @author caiger
 */
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		int len = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				int k = j + 1, l = len - 1;
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						// 利用hashset判断每组结果是否相同
						if (!set.contains(temp)) {
							set.add(temp);
							res.add(temp);
						}
						// 不能有相同的组
						k++;
						l--;
					} else if (sum < target)
						k++;
					else {
						l--;
					}
				}
			}
		}
		return res;
	}
}
