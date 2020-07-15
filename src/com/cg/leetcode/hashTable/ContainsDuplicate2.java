/**
 * 
 */
package com.cg.leetcode.hashTable;

import java.util.HashMap;

/**
 * 
 * Given an array of integers and an integer k, find out whether there there are
 * two distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 *
 * @author caiger
 */
public class ContainsDuplicate2 {
	public static void main(String[] args) {
		System.out
				.print(containsDuplicate(new int[] { 1, 2, 13, 4, 6, 5 }, 12));
	}

	public static boolean containsDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 2)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
				return true;
			else
				map.put(nums[i], i);
		}
		return false;
	}
}
