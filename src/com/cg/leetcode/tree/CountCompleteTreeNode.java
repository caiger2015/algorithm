/**
 * 
 */
package com.cg.leetcode.tree;

/**
 *
 * Given a complete binary tree, count the number of nodes. In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author caiger
 */
public class CountCompleteTreeNode {

	public static void main(String[] args) {

	}

	/**
	 * description：计算以root为根的完全二叉树的结点树； 根据完全二叉树的性质：左右两侧结点树最多差1，如果左右两侧结点数相同，
	 * 则为满二叉树，节点个数为2^h-1,h为层数，若两侧结点数不同，则对二叉树分左右子树进行递归计算， 结点树为左右子树结点树之和加1
	 * 
	 * @param root
	 *            一棵完全二叉树的根结点
	 * @return 以该结点为根的二叉树的结点个数
	 */
	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = 0, right = 0;
		TreeNode templ = root, tempr = root;
		while (templ != null) {
			left++;
			templ = templ.left;
		}
		while (tempr != null) {
			right++;
			tempr = tempr.right;
		}
		if (left == right)
			// 用pow函数会超时，因为是对2的整数次幂的操作，可以用移位操作来代替！！
			// return (int)Math.pow(2, left)-1;
			return (1 << left) - 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

}
