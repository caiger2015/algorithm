package com.cg.leetcode.divideAndConquer;

public class FindKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(findKthLargest(new int[] { -1, 2, 0 }, 1));
	}

	public static int findKthLargest(int[] nums, int k) {
		int begin = 0;
		int end = nums.length - 1;
		// 初始化为0时，当k == 1时会跳过循环返回错误的结果，
		// 应当把index初始化为一个k-1不会取到的值如-1，保证循环的第一次进行
		// 或者使用do while
		int index = 0;
		// 第k个大的数，从大到小排列下标是k-1
		do {
			index = partition(nums, begin, end);
			if (index < k - 1)
				begin = index + 1;
			else if (index > k - 1)
				end = index - 1;
		} while (index != k - 1);
		return nums[index];
	}

	private static int partition(int[] nums, int begin, int end) {
		int temp = nums[begin];
		while (begin < end) {
			while (begin < end && temp > nums[end])
				end--;
			nums[begin] = nums[end];
			while (begin < end && temp <= nums[begin])
				begin++;
			nums[end] = nums[begin];
		}
		nums[begin] = temp;
		return begin;
	}
}
