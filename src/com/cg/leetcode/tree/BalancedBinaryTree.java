package com.cg.leetcode.tree;

/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * AVLƽ�������������һ�ſ����������������������߶�֮�����ֵ������1����������������Ҳ��ƽ�������
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return getHeight(root) == -1 ? false : true;
	}

	// ������ȷ�ʽ�ݹ������������
	private int getHeight(TreeNode p) {
		// �趨�ݹ鷵������
		if (p == null)
			return 0;
		// �ݹ����
		int left = getHeight(p.left);
		int right = getHeight(p.right);
		// �Եݹ鷵�ؽ�������ж�
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
}
