package com.cg.leetcode.tree;

/**
 * @author caiger
 *
 */
public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {

	}

	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null)
				root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}