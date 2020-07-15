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
	 * description：从begin到end的排序的数组中找到最中间的节点作为一个左/右孩子。
	 * 
	 * @param nums 要转换的数组
	 * @param begin 结束寻找的索引
	 * @param end 开始寻找的索引
	 * @return 返回从数组中找到的结点
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
