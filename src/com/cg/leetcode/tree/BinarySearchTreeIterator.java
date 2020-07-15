package com.cg.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author caiger
 *
 */
public class BinarySearchTreeIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// �洢���е�ÿ���ڵ�
	private List<Integer> valList = new LinkedList<Integer>();
	private int index = 0;

	// �������BST���Ϊ��������,���ռ临�Ӷ�ΪO(n)����Ϊ�洢�����еĽڵ㡣
	// ��Ϊ�ڵ���next()��ʱ��Ѱ�ҵ�����һ���ڵ㣬����֮ǰ�Ľڵ����ɾ������Լ�ռ䡣
	public BinarySearchTreeIterator(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			valList.add(temp.val);
			temp = temp.right;
		}
	}

	/** @return whether we have a next smallest number */
	// ÿ�ε���hasNext����������һ����ָ������ƶ�һλ
	public boolean hasNext() {
		if (index < valList.size()) {
			index++;
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	// ���ص���ָ���ǰһ��Ԫ��
	public int next() {
		return valList.get(index - 1);
	}
}

class BinarySearchTreeIterator2 {

	// ÿ�θ���ջ��Ľڵ㣬��֤ջ���Ľ������һ��С�ģ���ʱ�ռ临�Ӷ�ΪO(h)
	private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	private TreeNode cur = null;
	//��ʼ��ʱ��������ķ�ʽ����ڵ㵽ջ��ֱ����С�Ľڵ㣨����ˣ�����ջ������֤��ջ������ڵ�ʱ�Ǵ���С�Ŀ�ʼ�ġ�
	public BinarySearchTreeIterator2(TreeNode root) {
		cur = root;
		while(cur != null){
			stack.push(cur);
			cur=cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	//���ջ��Ϊ�ձ�ʾ������һ��
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	// ���ص���ָ���ǰһ��Ԫ��
	//��ʵ���ǰ�һ�����������������ֿ��ˣ����ǽ�Լ�˿ռ�
	public int next() {
		int res = 0;
		if(!stack.isEmpty()){
			cur = stack.pop();
			res= cur.val;
			cur = cur.right;
			while(cur!=null){
				stack.push(cur);
				cur= cur.left;
			}
		}
		return res;
	}
}
/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

