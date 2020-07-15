package com.cg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author caiger
 */
public class PathSum2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		// 先根顺序遍历二叉树，递归方法
		List<Integer> path = new ArrayList<Integer>();
		getPath(root, res, sum, path);
		return res;
	}

	/**
	 * @param p
	 *            递归当前的二叉树的根结点
	 * @param res
	 *            要返回的path list
	 * @param sum
	 *            递归当前的所求结果
	 * @param path
	 *            递归过程中存储路径的list Tips：二叉树问题的求解框架式二叉树先、中、后序的递归遍历。
	 *            在递归调用的过程中，不仅可以通过返回值来求解，还可以通过传递的参数来求解，
	 *            在递归的开始部分判定递归返回的条件，进入的地方更新传递的参数，跳出的地方维护传递的参数
	 *
	 */
	// 先序递归的方式调用，在递归过程中传递path要进行维护
	private void getPath(TreeNode p, List<List<Integer>> res, int sum,
			List<Integer> path) {
		// 开始
		if (p == null)
			return;
		// 进入
		sum -= p.val;
		path.add(p.val);
		if (p.left == null && p.right == null && sum == 0) {
			// 每次在res中加入new的path路径
			res.add(new ArrayList<Integer>(path));
		}
		if (p.left != null) {
			getPath(p.left, res, sum, path);
			// 一次递归结束时移除这次递归时加入到path中的元素，索引为最后一位
			// sum因为是基本类型，值传递，不需要进行维护
			path.remove(path.size() - 1);
		}
		if (p.right != null) {
			getPath(p.right, res, sum, path);
			// 跳出
			path.remove(path.size() - 1);
		}
	}
	// 未验证：用循环实现递归的思路
	// private List<List<Integer>> pathSum2(TreeNode root, int sum){
	// List<List<Integer>> res = new ArrayList<List<Integer>>();
	// if(root==null){
	// return res;
	// }
	// TreeNode temp = root;
	// Deque<TreeNode> stack = new LinkedList<TreeNode>();
	// LinkedList<TreeNode> path = new LinkedList<TreeNode>();
	// while(temp!= null||!stack.isEmpty()){
	// while(temp!=null){
	// sum-=temp.val;
	// stack.addLast(temp);
	// path.add(temp);
	// temp=temp.left;
	// }
	// //此时stack中存的不是path路径，
	// temp=stack.pollLast();
	// if(temp.right==null){
	// if(temp.left==null&&sum==0){
	// res.add(getPathList(path));
	// }
	// path = new LinkedList<TreeNode>(stack);
	// }else{
	// temp=temp.right;
	// }
	// }
	// return res;
	// }
	//
	// /**
	// * @param stack
	// * @return
	// */
	// private List<Integer> getPathList(Deque<TreeNode> stack) {
	// List<Integer> path = new ArrayList<Integer>();
	// for(TreeNode p : stack){
	// path.add(p.val);
	// }
	// return path;
	// }
}
