package com.cg.leetcode.tree;

public class ConstuctTreeFromPreorderAndInorderTranversal {

	public static void main(String[] args) {
		TreeNode t = buildTree(new int[] { 1, 2, 4, 5, 3, 6 }, new int[] { 4,
				2, 5, 1, 6, 3 });
		System.out.print(t);
	}

	public static TreeNode buildTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0)
			return null;
		TreeNode root = construct(pre, 0, in, 0, pre.length);
		return root;
	}

	/**
	 * description�����η��������������е�һ���Ǹ���㣬Ȼ���������������ҵ�����λ�ã�
	 * ��������������ұ�����������ȷ�����Ⱥ�������������ȷ���������飬�ݹ鷽ʽȷ�����ҽ��
	 * 
	 * @param pre��������
	 * @param i��ʼ����
	 * @param in��������
	 * @param j��ʼ����
	 * @param len����
	 * @return
	 */
	private static TreeNode construct(int[] pre, int i, int[] in, int j, int len) {
		if (len == 0 || i >= pre.length || j >= in.length)
			return null;
		int temp = pre[i], k = 0;
		TreeNode root = new TreeNode(temp);
		while (k < len && in[k + j] != temp) {
			k++;
		}
		root.left = construct(pre, i + 1, in, j, k);
		root.right = construct(pre, i + 1 + k, in, j + k + 1, len - k - 1);
		return root;
	}
}
