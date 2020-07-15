package com.cg.leetcode.dynamicProgramming;

public class UniquePath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int uniquePath2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] res = new int[n];
		if (grid[0][0] == 1)
			res[0] = 0;
		else
			res[0] = 1;
		for (int i = 0; i < m; i++) {
			// 考虑限制条件可能影响到的所有地方
			// 这里判定每排第一个的时候，还要考虑上一排的情况
			if (grid[i][0] == 1 || res[0] == 0)
				res[0] = 0;
			else
				res[0] = 1;
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1)
					res[j] = 0;
				else
					res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}

}
