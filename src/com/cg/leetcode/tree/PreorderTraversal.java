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
public class PreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		preOrder(root, res);
		return res;
	}

	private void preOrder(TreeNode p, ArrayList<Integer> res) {
		if (p == null)
			return;
		res.add(p.val);
		preOrder(p.left, res);
		preOrder(p.right, res);
	}

	// 循环实现
	public List<Integer> preorder_Traversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		// 当temp == root时，stack为空
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				res.add(temp.val);
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop().right;
		}
		return res;
	}
}
