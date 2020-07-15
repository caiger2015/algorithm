package com.cg.leetcode.tree;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode pNode = new TreeNode(0);
		pNode.left = new TreeNode(1);
		TreeNode qNode = new TreeNode(0);
		qNode.left = new TreeNode(1);
		System.out.print(isSameTree(pNode, qNode) + "");
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;

	}
}
