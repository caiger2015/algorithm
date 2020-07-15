/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * @author caiger
 *
 */
public class ConstuctTreeFromPostorderAndInorderTranversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t = buildTree(new int[] { 4, 5, 2, 6, 3, 1 }, new int[] { 4,
				2, 5, 1, 3, 6 });
		System.out.print(t);
	}

	public static TreeNode buildTree(int[] in, int[] post) {
		if (post == null || in == null || post.length == 0 || in.length == 0)
			return null;
		TreeNode root = construct(post, post.length - 1, in, 0, in.length);
		return root;
	}

	/**
	 * description:分治法处理，后序数组中最后一个是根结点，然后在中序数组中找到它的位置，
	 * 左边是左子树，右边是右子树，确定长度后在后序数组中确定子树数组，递归方式确定左右结点
	 * 
	 * @param post
	 *            后序数组
	 * @param i
	 *            后序子树末尾节点，即为该子树根结点
	 * @param in
	 *            中序数组
	 * @param j
	 *            中序子树起始索引
	 * @param len
	 *            中序子树节点长度
	 * @return 一次递归的头结点
	 */
	private static TreeNode construct(int[] post, int i, int[] in, int j,
			int len) {
		if (len == 0 || i < 0 || j >= in.length || i >= in.length)
			return null;
		int temp = post[i];
		TreeNode p = new TreeNode(temp);
		int k = 0;
		while (k < len && temp != in[j + k])
			k++;
		p.left = construct(post, i - len + k, in, j, k);
		p.right = construct(post, i - 1, in, j + k + 1, len - k - 1);
		return p;
	}
}
