/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caiger
 *
 */
public class PostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		postorderTraversal(root, res);
		return res;
	}

	/**
	 * @param root
	 *            遍历的二叉树根结点
	 * @param res
	 *            要返回的list
	 */
	private void postorderTraversal(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		postorderTraversal(root.left, res);
		postorderTraversal(root.right, res);
		res.add(root.val);
	}

	/*
	 * 循环实现：利用stack来调整进入res的顺序，每个结点都是入栈，要考虑的是何时出栈进入res的条件，即对栈顶结点进行判定
	 * 
	 * @param pre：上一个出栈进入res的结点
	 * 
	 * @param cur：当前栈顶的结点 进入res的条件：1.当前栈顶结点左右结点都为null； 2.当前栈顶结点的左右结点都已经进入res
	 * 否则：将当前栈顶结点的右、左孩子结点入栈
	 */
	public List<Integer> postorder_Traversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode cur = root;
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (cur.left == null && cur.right == null || pre != null
					&& (pre == cur.left || pre == cur.right)) {
				res.add(cur.val);
				pre = cur;
				stack.pop();
			} else {
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
		return res;
	}
}
