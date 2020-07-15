/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * @author caiger
 *
 */
public class SortedArrayToBST {
	public static void main(String[] args) {
		System.out.print(sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int n = nums.length;
		return sortedArrayToBST(nums, 0, n - 1);
	}

	/**
	 * description����begin��end��������������ҵ����м�Ľڵ���Ϊһ����/�Һ��ӡ�
	 * 
	 * @param numsҪת��������
	 * @param begin����Ѱ�ҵ�����
	 * @param end��ʼѰ�ҵ�����
	 * @return ���ش��������ҵ��Ľ��
	 */
	private static TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
		if (begin <= end) {
			int mid = (begin + end) / 2;
			TreeNode res = new TreeNode(nums[mid]);
			res.left = sortedArrayToBST(nums, begin, mid - 1);
			res.right = sortedArrayToBST(nums, mid + 1, end);
			return res;
		}
		return null;
	}
}
