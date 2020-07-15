package com.cg.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author caiger Given a binary tree, return all root-to-leaf paths.
 * 
 *         For example, given the following binary tree:
 * 
 *         1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 *         ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode r = ConstructTree.constructTree("1235");
		List<String> s = binaryTreePaths(r);
		System.out.print(s);
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<String>();
		if (root == null) {
			return res;
		}
		StringBuffer path = new StringBuffer();
		getPaths(root, res, path);
		return res;
	}

	/**
	 * @param root
	 * @param res
	 * @param path
	 * @return
	 */
	private static void getPaths(TreeNode root, List<String> res,
			StringBuffer path) {
		if (root == null) {
			return;
		}
		// ע�͵��ķ�ʽ���У�����һ��path������
		if (root.left != null) {
			StringBuffer temp1 = new StringBuffer(path);
			temp1.append(root.val + "->");
			getPaths(root.left, res, temp1);
			// path.append(root.val);
			// getPaths(root.left,res,path);
		}
		if (root.right != null) {
			StringBuffer temp2 = new StringBuffer(path);
			temp2.append(root.val + "->");
			getPaths(root.right, res, temp2);
			// path.append(root.val);
			// getPaths(root.right,res,path);
		}
		if (root.left == null && root.right == null) {
			StringBuffer temp3 = new StringBuffer(path);
			temp3.append(root.val);
			res.add(temp3.toString());
			// path.append(root.val);
			// res.add(path.toString());
		}
	}

}
