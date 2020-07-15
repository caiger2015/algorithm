package com.cg.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c  =  0?
 * Find all unique triplets in the array which gives the sum of zero
 * 暴力寻找时间复杂度O(n^3)，而且要处理排序问题，可以先处理排序问题Arrays.sort();
 * 对排好序的数列处理复杂度低,而且可以很好的处理重复问题
 */
public class Sum3 {

	public void main(String[] args) {
		// TODO Auto-generated method stub
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] num) {
		if (num.length <= 2 || num == null)
			return res;
		Arrays.sort(num);// 排序数组，对有序数组进行查找效率高
		int len = num.length;
		for (int i = 0; i < len - 2 && num[i] <= 0; i++) {
			// 排出重复的结果
			if (i > 0 && num[i] == num[i - 1])
				continue;
			find(num, i + 1, len - 1, num[i]);
		}
		return res;
	}

	public void find(int[] num, int begin, int end, int target) {
		// 双指针寻找，比双层for循环时间复杂度低，因为已经排序了
		while (begin < end) {
			if (target + num[begin] + num[end] == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(target);
				ans.add(num[begin]);
				ans.add(num[end]);
				res.add(ans);
				// 排除相同的搜索
				while (begin < end && num[begin] == num[begin + 1])
					begin++;
				while (begin < end && num[end] == num[end - 1])
					end--;
				begin++;
				end--;
			} else if (target + num[begin] + num[end] > 0)
				end--;
			else {
				begin++;
			}
		}
	}
}
