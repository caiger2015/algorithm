package com.cg.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author caiger Given a binary search tree, write a function kthSmallest to
 *         find the kth smallest element in it.
 * 
 *         Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 *         Follow up: What if the BST is modified (insert/delete operations)
 *         often and you need to find the kth smallest frequently? How would you
 *         optimize the kthSmallest routine?
 *         O(h)方式的算法：在结点中加入一个属性，表示该节点的左子树的节点数m：若m>k则kth结点在左子树，
 *         若m-1<k则kth结点在右子树，若m-1=k则该节点为kth结点。
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
