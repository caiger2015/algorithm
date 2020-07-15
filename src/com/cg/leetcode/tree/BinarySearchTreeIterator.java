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

	// 存储树中的每个节点
	private List<Integer> valList = new LinkedList<Integer>();
	private int index = 0;

	// 中序遍历BST结果为升序排列,但空间复杂度为O(n)，因为存储了所有的节点。
	// 因为在调用next()的时候寻找的是下一个节点，所以之前的节点可以删除，节约空间。
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
	// 每次调用hasNext，若还有下一个则指针向后移动一位
	public boolean hasNext() {
		if (index < valList.size()) {
			index++;
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	// 返回的是指针的前一个元素
	public int next() {
		return valList.get(index - 1);
	}
}

class BinarySearchTreeIterator2 {

	// 每次更新栈里的节点，保证栈顶的结点是下一个小的，此时空间复杂度为O(h)
	private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	private TreeNode cur = null;
	//初始化时按照中序的方式放入节点到栈中直到最小的节点（最左端）到达栈顶，保证从栈里输出节点时是从最小的开始的。
	public BinarySearchTreeIterator2(TreeNode root) {
		cur = root;
		while(cur != null){
			stack.push(cur);
			cur=cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	//输出栈不为空表示还有下一个
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	// 返回的是指针的前一个元素
	//其实就是把一次完整的中序遍历拆分开了，但是节约了空间
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

