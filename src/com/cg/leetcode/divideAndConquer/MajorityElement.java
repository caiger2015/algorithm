package com.cg.leetcode.divideAndConquer;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(majorityElement(new int[] { 0, 5, 2, 5, 5, 4, 5 }));
	}

	/*
	 * 更优秀的方法O(n)：统计数组中数字的次数，如果与前一个数字相同则+1，不同-1，次数为0时记住下一个数并+1，
	 * 那么最后一次次数为1的那个数就是要找的
	 */
	public static int majorityElement1(int[] nums) {
		int n = nums.length;
		int res = nums[0];// 记录第一个数字
		int count = 1;// 记录一次
		for (int i = 1; i < n; i++) {
			if (count == 0) {
				res = nums[i];
				count++;
			} else if (nums[i] == res)
				count++;
			else {
				count--;
			}
		}
		return res;
	}

	public static int majorityElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		return nums[findMajority(left, right, nums)];
	}

	private static int findMajority(int left, int right, int[] nums) {
		int target = nums.length / 2;
		int res = partition(left, right, nums);
		while (res != target) {
			// 每次partition的时候有可能互相进入，因为left和right不变，1返回right，2返回left则进入死循环，
			// 要保证partition排序的数nums[left]不重复，所以要同时更新left和right！！！
			// (在快排中，递归调用自动更新了partition的left和right）
			if (res > target) {
				right = res - 1;// 这一步将nums数组逐渐分组
				res = partition(left, right, nums);// 1
			} else if (res < target) {
				left = res + 1;
				res = partition(left, right, nums);// 2
			}
		}
		return target;

	}

	// private static boolean complete(int target, int res, int[] nums) {
	// // TODO Auto-generated method stub
	// for(int i = target;i<= res;i++){
	// if(nums[i] != nums[res])
	// return false;
	// }
	// return true;
	// }
	private static int partition(int left, int right, int[] nums) {
		// 要考虑相等的情况，相等的放前边，那么返回的是所有相的元素的最后一个索引！！！
		// 而每次排序的是left是第一个位置的元素，有可能永远无法返回target
		// 例如输入[1,2,2,2,3],第一次排序返回索引0，接着排序2返回索引3，然后每次都要排序2，返回索引3，进入死循环！
		int temp = nums[left];
		while (left < right) {
			// 取等的判定放在前边，
			while (left < right && temp < nums[right])
				right--;
			nums[left] = nums[right];
			while (left < right && temp >= nums[left])
				left++;
			nums[right] = nums[left];
		}
		nums[left] = temp;
		return left;
	}
}
