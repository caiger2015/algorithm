/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {

	}
	public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
	/**
	 * ��̬�滮����i����Ϊ���ڵ�ʱ������������1~i-1�Ľ����ɵ�bst������������i+1~n�Ľ����ɵ�bst
	 * 			  ������������ϼ�ΪiΪ��ʱbst�����й��ɡ����õݹ�ķ�ʽ��ÿ�η�����õ�bstͷ��㡣
	 * 			 ���ս��Ҫ���ص���List<TreeNode>,�����ڶ�̬�滮�����о������������ⷵ�صĽ�������Ƹ�����Ľ����
	 * @param begin
	 * @param end
	 * @return ��begin��end�����нڵ���ɵ�BST
	 */
	private List<TreeNode> generateTrees(int begin, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (begin > end) {
			// ��ʾ���Ϊ�գ�List�д洢null
			res.add(null);
			return res;
		}
		for (int i = begin; i <= end; i++) {
			// ת��Ϊ��������⣬�ݹ���ã�������������ļ��ϣ���UniqueBST1�л����С�
			List<TreeNode> left = generateTrees(begin, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			// ���������������
			for (TreeNode l : left)
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
		}
		return res;
	}
}
