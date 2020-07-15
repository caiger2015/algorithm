package com.cg.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author caiger Given a binary search tree, write a function kthSmallest to
 *         find the kth smallest element in it.
 * 
 *         Note: You may assume k is always valid, 1 �� k �� BST's total elements.
 * 
 *         Follow up: What if the BST is modified (insert/delete operations)
 *         often and you need to find the kth smallest frequently? How would you
 *         optimize the kthSmallest routine?
 *         O(h)��ʽ���㷨���ڽ���м���һ�����ԣ���ʾ�ýڵ���������Ľڵ���m����m>k��kth�������������
 *         ��m-1<k��kth���������������m-1=k��ýڵ�Ϊkth��㡣
 */
public class KthSmallestElementinaBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t = ConstructTree.constructTree("213");
		System.out.print(kthSmallest(t, 3));
	}

	public static int kthSmallest(TreeNode root, int k) {
		TreeNode temp = root;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			if (--k == 0) {
				return temp.val;
			}
			temp = temp.right;
		}
		return root.val;
	}
}
