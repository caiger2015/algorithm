/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * Definition for a binary tree node.
 * 
 * @author caiger
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 用“#”表示null，按层打印以该节点为根节点的二叉树
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		levelprint(this, s);
		return s.toString();
	}

	/**
	 * @param treeNode
	 * @param s
	 */
	private void levelprint(TreeNode p, StringBuilder s) {
		if (p == null)
			return;
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		que.add(p);
		s.append(p.val);
		TreeNode temp;
		while (!que.isEmpty()) {
			temp = que.poll();
			if (temp.left != null) {
				s.append(temp.left.val);
				que.add(temp.left);
			} else
				s.append('#');
			if (temp.right != null) {
				s.append(temp.right.val);
				que.add(temp.right);
			} else
				s.append('#');
		}
		while (s.charAt(s.length() - 1) == '#')
			s.deleteCharAt(s.length() - 1);
	}
}
