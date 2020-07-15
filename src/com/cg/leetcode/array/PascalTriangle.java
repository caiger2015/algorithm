package com.cg.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(generate(5).toString());
	}

	public static List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> pre = null;
		for (int i = 1; i <= numRows; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i)
					temp.add(1);
				else {
					temp.add(pre.get(j - 2) + pre.get(j - 1));
				}
			}
			res.add(temp);
			pre = temp;
		}
		return res;
	}
}
