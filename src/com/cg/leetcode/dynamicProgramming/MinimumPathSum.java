package com.cg.leetcode.dynamicProgramming;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int minPathSum(int[][] grid){
		if(grid == null||grid[0] == null||grid.length == 0||grid[0].length == 0)
				return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] res = new int[n];
		//��ʼ����һ��
		res[0] = grid[0][0];
		for(int i = 1;i<n;i++)
			//����ÿ�е�һ��
			res[i] = res[i-1]+grid[0][i];
		for(int i = 1;i<m;i++){
			res[0] += grid[i][0];
			for(int j = 1;j<n;j++){
				res[j] = Math.min(res[j], res[j-1])+grid[i][j];
			}
		}
		return res[n-1];
	}
}
