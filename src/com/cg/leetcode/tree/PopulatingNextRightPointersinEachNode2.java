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
//������˳�����Ҫ�����������ķ�ʽ����ô�������߲��ֵ�next���γɣ����ұߵĲ�����������˳��û���γ�
//����һ�㹹��nextʱ�������ϲ�next����ֶϲ㣬���Ӧ�ò����ҽ����������ķ�ʽ��
//	connect(root.left);
//	connect(root.right);
//��̬�滮��˼�룬�������״̬��ʼ���죬����Խ�����Խ�繹��
	connect(root.right);
	connect(root.left);
}
/**
 * @param next 
 * @return	����next�ڵ��һ��������Ϊroot����next���
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
	//�����˼·����Ϊ����������Ķ�����������һ������next���δ���������ڵ��next���ĺ��Ӽ�����
	//��Ӧ���ڸ��ڵ���һ��Ľڵ�����к��ӽڵ��еĵ�һ��������nextָ��������ÿһ��Ѱ��
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
