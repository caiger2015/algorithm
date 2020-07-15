/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 *   1 
 *  / \ 
 * 2   3 Return 6.
 * 
 * @author caiger
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return max;
	}

	/**
	 * @param root
	 *            ��root�����·����,ֻ������ͷ��
	 *            1.�Ըýڵ�Ϊ����㣬���඼���ǵ�pathsum��max�Ƚ���Ϊ����
	 *            2.�Ըýڵ�Ϊ��/���ӽ�㣬ֻ����һ��·��ʱ���������ͣ����õݹ���ж�̬�滮
	 *            description�����õݹ���ж�̬�滮�����ս���ÿ�����Ϊ��ʱ�����·���͵����ֵ���������������ӽ���·������
	 *            ������Ҫ��������ӽ���·���ͣ��ʲ��ú��������DFS
	 */
	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int curMax = root.val;
		if (left > 0)
			curMax += left;
		if (right > 0)
			curMax += right;
		// �Ƚ�ÿ������������·���ͣ�����max
		max = Math.max(max, curMax);
		// ������rootΪ�ӽ���һ��·�����ֵ
		return Math.max(left + root.val, Math.max(right + root.val, root.val));
	}

}
