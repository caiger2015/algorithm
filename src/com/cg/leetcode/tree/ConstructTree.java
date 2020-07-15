/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 为了进行调试而创建的类，可以根据leetcode对二叉树的表现形式建立二叉树，即用“#”表示null的层遍历
 * 
 * @author caiger
 */
public class ConstructTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(constructTree("1#23#45"));
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.right = new TreeNode(4);
		p.right.left = new TreeNode(5);
		p.right.right = new TreeNode(6);
		p.right.left.right = new TreeNode(7);
		System.out.println(p);
		System.out.println(new InorderTraversal().inorderTraversal(p));
		System.out.println(new InorderTraversal()
				.inorderTraversal(constructTree("1#23#45")));
		System.out.println(new PreorderTraversal()
				.preorderTraversal(constructTree("1#23#45")));
		System.out.println(new LevelorderTraversal()
				.levelorderTraversal(constructTree("1#23#45")));
	}
	//二叉树层遍历的逆过程，用"#"代替空的结点把二叉树看成一棵满二叉树。
	public static TreeNode constructTree(String s) {
		if (s == null)
			return null;
		TreeNode root = new TreeNode(s.charAt(0) - '0');// char可以隐式转换成int
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		int i = 1, n = s.length();
		TreeNode temp;
		while (!que.isEmpty() && i < n) {
			temp = que.poll();
			// 越界的判定放在&&的前边
			if (i < n && s.charAt(i) != '#') {
				temp.left = new TreeNode(s.charAt(i) - '0');
				que.add(temp.left);
			}
			i++;
			if (i < n && s.charAt(i) != '#') {
				temp.right = new TreeNode(s.charAt(i) - '0');
				que.add(temp.right);
			}
			i++;
		}
		return root;
	}
}
