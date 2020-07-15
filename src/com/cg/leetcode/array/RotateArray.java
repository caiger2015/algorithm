package com.cg.leetcode.array;

/*
 * Rotate an array of n elements to the right by k steps.
 For example, with n  =  7 and k  =  3, 
 the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// rotate(new int[]{1,2,3,4,5,6},2);
	}

	/*
	 * 分步骤翻转：第一步翻转整个数组，第二部分别翻转两个子数组， 类似的例子：rotate bits，翻转一个2^n位数的所有比特位，
	 * 这种方法不用考虑越界，采用移位>>>,<<<,&某个数取位的方法。
	 */
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		if (nums == null || k <= 0 || n <= 1)
			return;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);

	}

	private void reverse(int[] A, int left, int right) {
		while (left < right) {
			int temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++;
			right--;
		}
	}

	/*
	 * 从结果来看，第i个元素的最终位置是（i+k）%n） 所以只要遍历完每个元素确定位置即可
	 */
	public static void rotate3(int[] nums, int k) {
		int n = nums.length;
		/*
		 * 别忘记！！！判断特殊情况，null,0,Integer.MINVALUE等
		 */
		if (nums == null || k <= 0 || n <= 0)
			return;
		int start = 0;
		k %= n;
		int next = start;
		/*
		 * 遍历一次，经过的是（next+k）%n 间隔为k的数， 从第一个数start开始 ，遍历完必然会回到start
		 */
		int temp = nums[start];
		for (int i = 0; i < n; i++) {
			next = (next + k) % n;
			int temp2 = nums[next];
			nums[next] = temp;
			temp = temp2;
			if (start == next) {
				start++;
				next = start % n;// 不要越界
				temp = nums[next];
			}
		}
	}

	/*
	 * 空间复杂度O（n）
	 */
	public void rotate2(int[] nums, int k) {
		int n = nums.length;
		int[] temp = new int[n];
		for (int i = 0; i < k; i++) {
			temp[i] = nums[n - k + i];
		}
		for (int j = k; j < n; j++) {
			temp[j] = nums[j - k];
		}
		for (int i = 0; i < n; i++) {
			nums[i] = temp[i];
		}
	}

	/*
	 * 移动次数太多，时间复杂度太大了O（k*n）
	 */
	public static void rotate1(int[] nums, int k) {
		k %= nums.length;
		while (k > 0) {
			int i = 0;
			int temp = nums[i];
			while (i < nums.length - 1) {
				nums[i] = nums[i + 1];
				i++;
			}
			nums[i] = temp;
			k--;
		}
	}
}
