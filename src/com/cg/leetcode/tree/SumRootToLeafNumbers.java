/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.ArrayList;

/**
 * @author caiger
 *
 */
public class SumRootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode p = ConstructTree.constructTree("12345");
		System.out.print(sumNumbers(p));
	}

	public static int sumNumbers(TreeNode root) {
		int res = 0;
		if (root == null)
			return res;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		getNumbers(root, res, numbers);
		for (Integer i : numbers)
			res += i;
		return res;
	}

	/**
	 * @param p��ǰ�Ľ��
	 * @param res��ǰ�ĺ�
	 * @param numbers�洢һ��root-leaf������
	 */
	private static void getNumbers(TreeNode p, int res,
			ArrayList<Integer> numbers) {
		res = res * 10 + p.val;
		if (p.left == null && p.right == null) {
			numbers.add(res);
		} else {
			if (p.left != null)
				getNumbers(p.left, res, numbers);
			if (p.right != null)
				getNumbers(p.right, res, numbers);
		}
	}
}
