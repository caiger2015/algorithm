package com.cg.leetcode.tree;

import java.util.ArrayList;

public class MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> stack = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			stack.add(1);
		}
		System.out.print(stack.size() + " ");
	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
