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
		// �ȸ�˳��������������ݹ鷽��
		List<Integer> path = new ArrayList<Integer>();
		getPath(root, res, sum, path);
		return res;
	}

	/**
	 * @param p
	 *            �ݹ鵱ǰ�Ķ������ĸ����
	 * @param res
	 *            Ҫ���ص�path list
	 * @param sum
	 *            �ݹ鵱ǰ��������
	 * @param path
	 *            �ݹ�����д洢·����list Tips������������������ʽ�������ȡ��С�����ĵݹ������
	 *            �ڵݹ���õĹ����У���������ͨ������ֵ����⣬������ͨ�����ݵĲ�������⣬
	 *            �ڵݹ�Ŀ�ʼ�����ж��ݹ鷵�ص�����������ĵط����´��ݵĲ����������ĵط�ά�����ݵĲ���
	 *
	 */
	// ����ݹ�ķ�ʽ���ã��ڵݹ�����д���pathҪ����ά��
	private void getPath(TreeNode p, List<List<Integer>> res, int sum,
			List<Integer> path) {
		// ��ʼ
		if (p == null)
			return;
		// ����
		sum -= p.val;
		path.add(p.val);
		if (p.left == null && p.right == null && sum == 0) {
			// ÿ����res�м���new��path·��
			res.add(new ArrayList<Integer>(path));
		}
		if (p.left != null) {
			getPath(p.left, res, sum, path);
			// һ�εݹ����ʱ�Ƴ���εݹ�ʱ���뵽path�е�Ԫ�أ�����Ϊ���һλ
			// sum��Ϊ�ǻ������ͣ�ֵ���ݣ�����Ҫ����ά��
			path.remove(path.size() - 1);
		}
		if (p.right != null) {
			getPath(p.right, res, sum, path);
			// ����
			path.remove(path.size() - 1);
		}
	}
	// δ��֤����ѭ��ʵ�ֵݹ��˼·
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
	// //��ʱstack�д�Ĳ���path·����
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
