/**
 * 
 */
package com.cg.leetcode.tree;

/**
 * @author caiger
 *Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

	}
	/*
	 * �ȴ洢����ı䣡
	 * flatten֮���˳�������������˳�򣬵����ڵݹ��ͬʱ��ı����Ľṹ������Ҫ�����ҽ���λ�ã�
	 * �������ʱ���ҽ��ŵ������������ұߵ��Ǹ��ڵ���ҽ��
	 */
	public static void flattenTreeToLinkedList(TreeNode root){
		if(root == null)
			return;
		if(root.left != null){
			TreeNode right = root.right;
			root.right = root.left;
			TreeNode mostRight = root.left;
			root.left = null;
			//�ҵ����������ұߵĽ�㣬��Ϊ�Һ��ӽ����linkedlist�е�ǰһ���ڵ�
			while(mostRight.right != null||mostRight.left != null){
				if(mostRight.right != null)
					mostRight = mostRight.right;
				else
					mostRight = mostRight.left;
			}
			mostRight.right = right;
			flattenTreeToLinkedList(root.right);
		}
	}

}
