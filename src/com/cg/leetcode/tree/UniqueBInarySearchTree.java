/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * @author caiger
 *Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n  =  3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBInarySearchTree {

	public static void main(String[] args) {
		System.out.print(numTrees(12));
	}

	/**
	 * ��̬�滮��һ��i����㣬��j�����Ϊ�����ʱ����������1~j-1�����ɣ���������j+1~i�����ɣ�
	 * ����ֻ���ǽṹ���⣬�������Ϊ��������j���ڵ㣬��������i-j-1����㡣������ϼ�Ϊ���нṹ
	 * 
	 * @param n
	 *            ��1~n��n������ʾn����ͬ�Ľ��
	 * @return ��ͬ�ṹ�Ķ������ĸ���
	 */
	public static int numTrees(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j] * res[i - j - 1];
			}
		}
		return res[n];
	}
}
