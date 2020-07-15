package com.cg.leetcode.tree;

/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 思路如下：一开始的想法是top-down的，每次判断根节点，先看它的左右子树是否包含p、q两个节点，两边都只包含一个时返回当前根结点为结果，
 * 否则以包含两个节点的那个子结点为新的根节点继续，这样处理每次会对深层的子树做多次重复的半段
 * 问题所在：通过判断左右结点的情况来决定根结点的过程正好符合后序遍历；
 * 算法改进：bottom-up的方式进行递归，将重复的子问题以合适的信息流传递，返回的结果可以是有用的信息，如果子节点的信息对判断有用， 可以先判断子结点。
 * 
 * @author caiger
 */
public class LowestCommonAncestorOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * @param root
	 * @param p
	 * @param q
	 * @return 每次递归返回的都是以root为根的子树中p与q的最小公共祖先
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}
}
