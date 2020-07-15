/**
 * 
 */
package com.cg.leetcode.tree;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * @author caiger
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	//用递归的方式求解要想清楚递归函数的参数和返回值，明白递归的意义！
	//想清楚递归的终止条件，迭代公式。
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		// 因为是判定到叶子结点的路径，所以要在递归开始时判定当前结点是否是叶子结点
		if (root.left == null && root.right == null)
			return root.val == sum ? true : false;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
