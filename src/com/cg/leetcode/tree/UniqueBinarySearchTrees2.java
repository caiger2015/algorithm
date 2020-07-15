/**
 * 
 */
package com.cg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {

	}
	public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
	/**
	 * 动态规划：第i个数为根节点时，左子树是由1~i-1的结点组成的bst，右子树是由i+1~n的结点组成的bst
	 * 			  左右子树的组合即为i为根时bst的所有构成。利用递归的方式，每次返回求得的bst头结点。
	 * 			 最终结果要返回的是List<TreeNode>,所以在动态规划过程中就是利用子问题返回的结果来递推父问题的结果。
	 * @param begin
	 * @param end
	 * @return 从begin到end的所有节点组成的BST
	 */
	private List<TreeNode> generateTrees(int begin, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (begin > end) {
			// 表示结点为空，List中存储null
			res.add(null);
			return res;
		}
		for (int i = begin; i <= end; i++) {
			// 转化为子问题求解，递归调用，获得左右子树的集合，从UniqueBST1中获得灵感。
			List<TreeNode> left = generateTrees(begin, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			// 交叉组合左右子树
			for (TreeNode l : left)
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
		}
		return res;
	}
}
