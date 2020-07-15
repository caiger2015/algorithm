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
	 * �ֲ��跭ת����һ����ת�������飬�ڶ����ֱ�ת���������飬 ���Ƶ����ӣ�rotate bits����תһ��2^nλ�������б���λ��
	 * ���ַ������ÿ���Խ�磬������λ>>>,<<<,&ĳ����ȡλ�ķ�����
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
	 * �ӽ����������i��Ԫ�ص�����λ���ǣ�i+k��%n�� ����ֻҪ������ÿ��Ԫ��ȷ��λ�ü���
	 */
	public static void rotate3(int[] nums, int k) {
		int n = nums.length;
		/*
		 * �����ǣ������ж����������null,0,Integer.MINVALUE��
		 */
		if (nums == null || k <= 0 || n <= 0)
			return;
		int start = 0;
		k %= n;
		int next = start;
		/*
		 * ����һ�Σ��������ǣ�next+k��%n ���Ϊk������ �ӵ�һ����start��ʼ ���������Ȼ��ص�start
		 */
		int temp = nums[start];
		for (int i = 0; i < n; i++) {
			next = (next + k) % n;
			int temp2 = nums[next];
			nums[next] = temp;
			temp = temp2;
			if (start == next) {
				start++;
				next = start % n;// ��ҪԽ��
				temp = nums[next];
			}
		}
	}

	/*
	 * �ռ临�Ӷ�O��n��
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
	 * �ƶ�����̫�࣬ʱ�临�Ӷ�̫����O��k*n��
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
