/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.*;

/**
 * @author caiger
 *
 */
public class BinaryTreeRightSideView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode p = ConstructTree.constructTree("123456");
		System.out.print(rightSideView(p).toString());
	}

	// 广度优先层遍历，找出每一层的最右边的那个元素
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		// cur表示当前层的节点数，next表示下一层的节点数
		int cur = 1, next = 0;
		que.add(root);
		TreeNode temp;
		while (!que.isEmpty()) {
			temp = que.poll();
			if (temp.left != null) {
				que.add(temp.left);
				next++;
			}
			if (temp.right != null) {
				que.add(temp.right);
				next++;
			}
			if (--cur == 0) {
				res.add(temp.val);
				cur = next;
				next = 0;
			}
		}
		return res;
	}

	// 深度优先算法如何能够记录当前的深度呢？待解决的问题！！！
	public static List<Integer> rightSideView1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		int depth = 1;
		stack.add(temp);
		res.add(temp.val);
		while (!stack.isEmpty()) {
			while (temp.right != null) {
				temp = temp.right;
				stack.add(temp);
				depth++;
				if (depth > res.size())
					res.add(temp.val);
			}
			if (temp.left != null) {
				temp = temp.left;
				stack.add(temp);
				depth++;
				if (depth > res.size())
					res.add(temp.val);
			} else if (!stack.isEmpty()) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				temp = stack.pop().left;
				depth--;
			}
		}
		return res;
	}
}
