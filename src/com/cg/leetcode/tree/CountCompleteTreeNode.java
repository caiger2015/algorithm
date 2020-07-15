/**
 * 
 */
package com.cg.leetcode.tree;

/**
 *
 * Given a complete binary tree, count the number of nodes. In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author caiger
 */
public class CountCompleteTreeNode {

	public static void main(String[] args) {

	}

	/**
	 * description��������rootΪ������ȫ�������Ľ������ ������ȫ�����������ʣ�����������������1�������������������ͬ��
	 * ��Ϊ�����������ڵ����Ϊ2^h-1,hΪ������������������ͬ����Զ������������������еݹ���㣬 �����Ϊ�������������֮�ͼ�1
	 * 
	 * @param root
	 *            һ����ȫ�������ĸ����
	 * @return �Ըý��Ϊ���Ķ������Ľ�����
	 */
	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = 0, right = 0;
		TreeNode templ = root, tempr = root;
		while (templ != null) {
			left++;
			templ = templ.left;
		}
		while (tempr != null) {
			right++;
			tempr = tempr.right;
		}
		if (left == right)
			// ��pow�����ᳬʱ����Ϊ�Ƕ�2���������ݵĲ�������������λ���������棡��
			// return (int)Math.pow(2, left)-1;
			return (1 << left) - 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

}
