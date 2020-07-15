/**
 * 
 */
package com.cg.leetcode.tree;

/**
 *
 * Two elements of a binary search tree (BST) are swapped by mistake. Recover
 * the tree without changing its structure. Note: A solution using O(n) space is
 * pretty straight forward. Could you devise a constant space solution?
 * 
 * @author caiger
 */
public class RecoverBinarySearchTree {

	public static void main(String[] args) {

	}

	private static TreeNode big = null;
	private static TreeNode small = null;
	private static TreeNode pre = null;

	public static void recoverTree(TreeNode root) {
		inorderTranversal(root);
		if (big != null && small != null) {
			int temp = small.val;
			small.val = big.val;
			big.val = temp;
		}
	}

	/**
	 * @param root
	 *            �������������
	 */
	private static void inorderTranversal(TreeNode root) {
		if (root == null)
			return;
		inorderTranversal(root.left);
		if (pre != null) {
			if (pre.val > root.val && big == null) {
				big = pre;
				small = root;
			}
			if (pre.val > root.val && big != null) {
				small = root;
			}
		}
		pre = root;
		inorderTranversal(root.right);
	}
}
