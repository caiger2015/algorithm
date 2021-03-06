package com.cg.leetcode.dynamicProgramming;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class UniqueBSTs {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(numTrees(3) + "");
	}

	/*
	 * 从根节点入手考虑，比它小的只能在左子树，大的在右子树
	 * 
	 * @param res[n]，存储结果
	 */
	public static int numTrees(int n) {
		int i = 0;
		int j = 0;
		int[] res = new int[n + 1];// 多一位存储输入为0的情况
		if (n == 0)
			return 1;
		res[0] = res[1] = 1;
		for (i = 2; i <= n; i++) {
			res[i] = 0;
			for (j = 0; j < i; j++) {
				res[i] += res[j] * res[i - j - 1];
			}
		}
		return res[n];
	}
}
