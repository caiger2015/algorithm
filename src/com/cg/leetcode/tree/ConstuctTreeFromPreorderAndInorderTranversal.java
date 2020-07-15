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
	 * description：分治法处理，先序数组中第一个是根结点，然后在中序数组中找到它的位置，
	 * 左边是左子树，右边是右子树，确定长度后在先序数组中确定子树数组，递归方式确定左右结点
	 * 
	 * @param pre 先序数组
	 * @param i 开始索引
	 * @param in 中序数组
	 * @param j 开始索引
	 * @param len 长度
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
