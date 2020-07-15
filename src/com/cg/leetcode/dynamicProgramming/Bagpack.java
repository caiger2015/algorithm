/**
 * 背包问题：n件（唯一）不同价值不同重量的物品放入容量c的背包，求出最大价值
 * @caiger
 */
package com.cg.leetcode.dynamicProgramming;

public class Bagpack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = new Bagpack().bagpack(2, 2, new int[] { 3, 2 }, new int[] { 1,
				2 });
		System.out.print(x + "");
	}

	public int bagpack(int n, int c, int[] w, int[] v) {
		int[][] res = new int[n][c + 1];// 之前数组大小为[n][c],当w[j] = i
		for (int[] i : res) { // 即放入的物品等于总重是需要单独考虑
			for (int j = 0; j < i.length; j++) { // 否则下标会溢出
				i[j] = 0;
			}
		}

		for (int i = 1; i <= c; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					// if(w[j]>i+1)//这里i+1是容量
					if (w[j] > i) {
						res[j][i] = 0;
					} else {
						res[j][i] = v[j];
					}
				} else {
					/*
					 * if(w[j]>i)//这里是判断序号的，但是遗漏了一种情况w[j] = i+1 { if(w[j] ==
					 * i+1&&res[j-1][i] == 0) res[j][i] = v[j]; else{ res[j][i]
					 * = res[j-1][i]; } }
					 */
					if (w[j] > i) {
						res[j][i] = res[j - 1][i];
					} else {
						res[j][i] = res[j - 1][i] > (res[j - 1][i - w[j]] + v[j]) ? res[j - 1][i]
								: res[j - 1][i - w[j]] + v[j];
					}
				}
			}
		}
		return res[n - 1][c];
	}
}
