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
	 * 先存储，后改变！
	 * flatten之后的顺序是先序遍历的顺序，但是在递归的同时会改变树的结构，所以要处理右结点的位置，
	 * 先序遍历时，右结点放到在左子树最右边的那个节点的右结点
	 */
	public static void flattenTreeToLinkedList(TreeNode root){
		if(root == null)
			return;
		if(root.left != null){
			TreeNode right = root.right;
			root.right = root.left;
			TreeNode mostRight = root.left;
			root.left = null;
			//找到左子树最右边的结点，即为右孩子结点在linkedlist中的前一个节点
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
