/**
 * 
 */
package com.cg.leetcode.tree;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * @author caiger
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	//�õݹ�ķ�ʽ���Ҫ������ݹ麯���Ĳ����ͷ���ֵ�����׵ݹ�����壡
	//������ݹ����ֹ������������ʽ��
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		// ��Ϊ���ж���Ҷ�ӽ���·��������Ҫ�ڵݹ鿪ʼʱ�ж���ǰ����Ƿ���Ҷ�ӽ��
		if (root.left == null && root.right == null)
			return root.val == sum ? true : false;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
