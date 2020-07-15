package com.cg.leetcode.tree;

/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * AVL平衡二叉树：它是一颗空树，或者它的左右子树高度之差绝对值不超过1，且它的左右子树也是平衡二叉树
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return getHeight(root) == -1 ? false : true;
	}

	// 深度优先方式递归遍历左右子树
	private int getHeight(TreeNode p) {
		// 设定递归返回条件
		if (p == null)
			return 0;
		// 递归调用
		int left = getHeight(p.left);
		int right = getHeight(p.right);
		// 对递归返回结果进行判定
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
}
