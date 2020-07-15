package com.cg.leetcode.binarySearch;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int left = 0, right = nums.length - 1;
		if (nums[left] <= nums[right])
			return nums[left];
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (nums[left] < nums[mid]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
