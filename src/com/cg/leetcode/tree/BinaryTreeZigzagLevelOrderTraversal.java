/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 @author caiger
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		System.out.print(zigzagLevelOrder(ConstructTree.constructTree("1#23#456")));
	}
	/*
	 * 逐层遍历，需要记录当前层和下一层的结点数，没完成一层层数加1，奇数层正序，偶数层反序。
	 */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null)
			return null;
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		//Deque接口有后进先出的堆栈功能
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		TreeNode temp = root;
		int now = 1,next = 0,levelCount = 1;
		que.add(temp);
		while(!que.isEmpty()){
			LinkedList<Integer> levelList = new LinkedList<Integer>();
			while(now>0){
				temp = que.poll();
				now--;
				addTreeNode(levelList,levelCount,temp.val);
				if(temp.left != null){
					que.add(temp.left);
					next++;
				}
				if(temp.right != null){
					que.add(temp.right);
					next++;
				}
			}
			now = next;
			next = 0;
			levelCount++;
			res.add(levelList);
		}
		return res;
	}
	/**
	 * @param levelList 二叉树的一层
	 * @param levelCount	二叉树的层数
	 * @param val	要添加的元素
	 */
	private static void addTreeNode(LinkedList<Integer> levelList, int levelCount,	int val) {
		//奇数层正序添加
		if((levelCount&1) == 1)
			levelList.add(val);
		//偶数层逆序添加
		else
			levelList.push(val);
	}
		
}
