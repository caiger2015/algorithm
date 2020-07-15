package com.cg.leetcode.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * @author caiger
 */
public class LowestCommonAncestorofaBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root == p || root == q)
				return root;
			if (p.val < root.val && q.val < root.val)
				root = root.left;
			else if (p.val > root.val && q.val > root.val)
				root = root.right;
			else
				return root;
		}
		return root;
	}
}
