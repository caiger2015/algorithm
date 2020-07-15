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
	 * 动态规划：一共i个结点，第j个结点为根结点时，左子树由1~j-1结点组成，右子树由j+1~i结点组成，
	 * 由于只考虑结构问题，可以理解为左子树有j个节点，右子树有i-j-1个结点。交叉组合即为所有结构
	 * 
	 * @param n
	 *            从1~n的n个数表示n个不同的结点
	 * @return 不同结构的二叉树的个数
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
