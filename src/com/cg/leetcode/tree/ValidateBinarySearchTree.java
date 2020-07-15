/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.LinkedList;

/**
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author caiger
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		System.out.print(isValidBST1(ConstructTree.constructTree("5382469")));
	}

	// 用最小int时取等的情况要单独考虑
	// private static int temp = Integer.MIN_VALUE;
	// 用Integer包装int，初始情况为空可以单独判断
	private static Integer temp = null;

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		/*
		 * BST中序遍历结果为升序，按照中序结构遍历BST比较当前结点和上一个输出结点的大小，
		 * 利用一个外部变量来存储上一个结点值，在递归时更新这个变量即可。用单个变量的更新代替了循环方法中堆栈的作用，节省了空间，缺点是要用到外部变量
		 */
		boolean left = isValidBST(root.left);
		if (temp == null || root.val > temp)
			temp = root.val;
		else
			return false;
		boolean right = isValidBST(root.right);
		return left && right;
	}

	/*
	 * 循环方式中序遍历BST，记录上一个出栈结点值为min，比较与当前出栈结点的大小
	 */
	public static boolean isValidBST1(TreeNode root) {
		if (root == null)
			return true;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = root;
		Integer min = null;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			if (min == null)
				min = temp.val;
			else {
				if (min >= temp.val)
					return false;
				else
					min = temp.val;
			}
			temp = temp.right;
		}
		return true;
	}
}
