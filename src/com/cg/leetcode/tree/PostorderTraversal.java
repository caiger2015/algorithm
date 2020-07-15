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
	 *            �����Ķ����������
	 * @param res
	 *            Ҫ���ص�list
	 */
	private void postorderTraversal(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		postorderTraversal(root.left, res);
		postorderTraversal(root.right, res);
		res.add(root.val);
	}

	/*
	 * ѭ��ʵ�֣�����stack����������res��˳��ÿ����㶼����ջ��Ҫ���ǵ��Ǻ�ʱ��ջ����res������������ջ���������ж�
	 * 
	 * @param pre����һ����ջ����res�Ľ��
	 * 
	 * @param cur����ǰջ���Ľ�� ����res��������1.��ǰջ��������ҽ�㶼Ϊnull�� 2.��ǰջ���������ҽ�㶼�Ѿ�����res
	 * ���򣺽���ǰջ�������ҡ����ӽ����ջ
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
