/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		preOrder(root, res);
		return res;
	}

	private void preOrder(TreeNode p, ArrayList<Integer> res) {
		if (p == null)
			return;
		preOrder(p.left, res);
		res.add(p.val);
		preOrder(p.right, res);
	}

	// ѭ��ʵ��
	public List<Integer> inorder_Traversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.add(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			res.add(temp.val);
			temp = temp.right;
		}
		return res;
	}
}
