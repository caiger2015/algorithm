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

	// ����Сintʱȡ�ȵ����Ҫ��������
	// private static int temp = Integer.MIN_VALUE;
	// ��Integer��װint����ʼ���Ϊ�տ��Ե����ж�
	private static Integer temp = null;

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		/*
		 * BST����������Ϊ���򣬰�������ṹ����BST�Ƚϵ�ǰ������һ��������Ĵ�С��
		 * ����һ���ⲿ�������洢��һ�����ֵ���ڵݹ�ʱ��������������ɡ��õ��������ĸ��´�����ѭ�������ж�ջ�����ã���ʡ�˿ռ䣬ȱ����Ҫ�õ��ⲿ����
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
	 * ѭ����ʽ�������BST����¼��һ����ջ���ֵΪmin���Ƚ��뵱ǰ��ջ���Ĵ�С
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
