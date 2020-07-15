package com.cg.leetcode.divideAndConquer;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(majorityElement(new int[] { 0, 5, 2, 5, 5, 4, 5 }));
	}

	/*
	 * ������ķ���O(n)��ͳ�����������ֵĴ����������ǰһ��������ͬ��+1����ͬ-1������Ϊ0ʱ��ס��һ������+1��
	 * ��ô���һ�δ���Ϊ1���Ǹ�������Ҫ�ҵ�
	 */
	public static int majorityElement1(int[] nums) {
		int n = nums.length;
		int res = nums[0];// ��¼��һ������
		int count = 1;// ��¼һ��
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
			// ÿ��partition��ʱ���п��ܻ�����룬��Ϊleft��right���䣬1����right��2����left�������ѭ����
			// Ҫ��֤partition�������nums[left]���ظ�������Ҫͬʱ����left��right������
			// (�ڿ����У��ݹ�����Զ�������partition��left��right��
			if (res > target) {
				right = res - 1;// ��һ����nums�����𽥷���
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
		// Ҫ������ȵ��������ȵķ�ǰ�ߣ���ô���ص����������Ԫ�ص����һ������������
		// ��ÿ���������left�ǵ�һ��λ�õ�Ԫ�أ��п�����Զ�޷�����target
		// ��������[1,2,2,2,3],��һ�����򷵻�����0����������2��������3��Ȼ��ÿ�ζ�Ҫ����2����������3��������ѭ����
		int temp = nums[left];
		while (left < right) {
			// ȡ�ȵ��ж�����ǰ�ߣ�
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
