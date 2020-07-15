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
	 * description:���η������������������һ���Ǹ���㣬Ȼ���������������ҵ�����λ�ã�
	 * ��������������ұ�����������ȷ�����Ⱥ��ں���������ȷ���������飬�ݹ鷽ʽȷ�����ҽ��
	 * 
	 * @param post
	 *            ��������
	 * @param i
	 *            ��������ĩβ�ڵ㣬��Ϊ�����������
	 * @param in
	 *            ��������
	 * @param j
	 *            ����������ʼ����
	 * @param len
	 *            ���������ڵ㳤��
	 * @return һ�εݹ��ͷ���
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
