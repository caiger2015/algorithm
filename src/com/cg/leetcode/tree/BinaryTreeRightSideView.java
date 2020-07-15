/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.*;

/**
 * @author caiger
 *
 */
public class BinaryTreeRightSideView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode p = ConstructTree.constructTree("123456");
		System.out.print(rightSideView(p).toString());
	}

	// ������Ȳ�������ҳ�ÿһ������ұߵ��Ǹ�Ԫ��
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		// cur��ʾ��ǰ��Ľڵ�����next��ʾ��һ��Ľڵ���
		int cur = 1, next = 0;
		que.add(root);
		TreeNode temp;
		while (!que.isEmpty()) {
			temp = que.poll();
			if (temp.left != null) {
				que.add(temp.left);
				next++;
			}
			if (temp.right != null) {
				que.add(temp.right);
				next++;
			}
			if (--cur == 0) {
				res.add(temp.val);
				cur = next;
				next = 0;
			}
		}
		return res;
	}

	// ��������㷨����ܹ���¼��ǰ������أ�����������⣡����
	public static List<Integer> rightSideView1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		int depth = 1;
		stack.add(temp);
		res.add(temp.val);
		while (!stack.isEmpty()) {
			while (temp.right != null) {
				temp = temp.right;
				stack.add(temp);
				depth++;
				if (depth > res.size())
					res.add(temp.val);
			}
			if (temp.left != null) {
				temp = temp.left;
				stack.add(temp);
				depth++;
				if (depth > res.size())
					res.add(temp.val);
			} else if (!stack.isEmpty()) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				temp = stack.pop().left;
				depth--;
			}
		}
		return res;
	}
}
