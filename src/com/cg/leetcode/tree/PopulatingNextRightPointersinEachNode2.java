/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * @author caiger
 *Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode2 {

	public static void main(String[] args) {

	}
	public void connect(TreeLinkNode root) {
	if(root == null)
		return;
	if(root.left != null){
		if(root.right != null)
			root.left.next = root.right;
		else
			root.left.next = getNext(root.next);
	}
	if(root.right != null){
		root.right.next = getNext(root.next);
	}
//遍历的顺序很重要！如果用先序的方式，那么根结点左边部分的next先形成，而右边的部分由于先序顺序还没有形成
//在下一层构造next时，查找上层next会出现断层，因此应该采用右结点先序遍历的方式。
//	connect(root.left);
//	connect(root.right);
//动态规划的思想，从最初的状态开始构造，查找越靠后的越早构造
	connect(root.right);
	connect(root.left);
}
/**
 * @param next 
 * @return	返回next节点的一个孩子作为root结点的next结点
 */
private TreeLinkNode getNext(TreeLinkNode next) {
	while(next != null){
		if(next.left != null)
			return next.left;
		else if(next.right != null)
			return next.right;
		else
			next = next.next;
	}
	return null;
}
	//错误的思路，因为可以是任意的二叉树，所以一个结点的next结点未必在它父节点的next结点的孩子几点中
	//而应该在父节点那一层的节点的所有孩子节点中的第一个，利用next指针来遍历每一层寻找
	public void connectWrong(TreeLinkNode root) {
		if(root == null)
			return;
		TreeLinkNode temp = root.next;
		if(root.left != null){
			root.left.next = (root.right == null?(temp == null?null:(temp.left == null?(temp.right == null?null:temp.right):temp.left)):root.right);
		}
		if(root.right != null){
			root.right.next = temp == null?null:(temp.left == null?(temp.right == null?null:temp.right):temp.left);
		}
		connect(root.left);
		connect(root.right);
	}
}
