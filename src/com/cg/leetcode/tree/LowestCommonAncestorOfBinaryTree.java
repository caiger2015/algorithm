package com.cg.leetcode.tree;

/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * ˼·���£�һ��ʼ���뷨��top-down�ģ�ÿ���жϸ��ڵ㣬�ȿ��������������Ƿ����p��q�����ڵ㣬���߶�ֻ����һ��ʱ���ص�ǰ�����Ϊ�����
 * �����԰��������ڵ���Ǹ��ӽ��Ϊ�µĸ��ڵ��������������ÿ�λ����������������ظ��İ��
 * �������ڣ�ͨ���ж����ҽ�����������������Ĺ������÷��Ϻ��������
 * �㷨�Ľ���bottom-up�ķ�ʽ���еݹ飬���ظ����������Ժ��ʵ���Ϣ�����ݣ����صĽ�����������õ���Ϣ������ӽڵ����Ϣ���ж����ã� �������ж��ӽ�㡣
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
	 * @return ÿ�εݹ鷵�صĶ�����rootΪ����������p��q����С��������
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
