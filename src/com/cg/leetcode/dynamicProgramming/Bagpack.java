/**
 * 背包问题：n件（唯一）不同价值不同重量的物品放入容量c的背包，求出最大价值
 *
 * @caiger
 */
package com.cg.leetcode.dynamicProgramming;

public class Bagpack {
	private static final int n = 2;
	private static final int c = 4;
	private static final int[] w = new int[]{3, 2};
	private static final int[] v = new int[]{1, 2};
	private static int max = 0;
	private static int[][] mem = new int[n][c];

    public static void main(String[] args) {
		System.out.println(new Bagpack().bagPack3(2, 4, new int[]{3, 2}, new int[]{1, 2}));
		new Bagpack().bagPack1(0, 0, 0);
		System.out.println(max);
    }

	/**
	 * 1、回溯法，过程中记录并更新结果
	 * @param i 处理第i个物品
	 * @param cv 当前价值
	 * @param cw 当前背包重量
	 */
	public void bagPack(int i, int cv, int cw) {
		//遇到终止条件返回
		if (i == n || cw >= c) {
			if (cv > max) {
				max = cv;
			}
			return;
		}
		//不放入的情况
		bagPack(i + 1, cv, cw);
		//放入的情况
		if (cw + w[i] <= c) {
			bagPack(i + 1, cv + v[i], cw + w[i]);
		}
	}

	/**
	 * 2、回溯+备忘录，过程中记录个状态结果，遇到相同状态是选择最优的继续，对递归二叉树进行剪枝，减少递归次数
	 * mem[i][cw] = cv; 表示决定放第i个物品缺背包重量为cw时的最打价值是cv
	 * @param i 处理第i个物品
	 * @param cv 当前价值
	 * @param cw 当前背包重量
	 */
	public void bagPack1(int i, int cv, int cw) {
		//遇到终止条件返回
		if (i == n || cw >= c) {
			if (cv > max) {
				max = cv;
			}
			return;
		}
		//淘汰掉同状态下价值小的情况
		if (mem[i][cw] < cv) {
			return;
		}
		//记录并更新已知状态的最优结果
		mem[i][cw] = cv;
		//不放入的情况
		bagPack(i + 1, cv, cw);
		//放入的情况
		if (cw + w[i] <= c) {
			bagPack(i + 1, cv + v[i], cw + w[i]);
		}
	}

    /**
     * 3、动态规划，状态转移表
     * dp[i][j]表示处理完第i个物品且背包容量为j时的最大价值
     * @param n 物品数
     * @param c 背包容量
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @return
     */
    public int bagPack2(int n, int c, int[] w, int[] v) {
        //dp[i][j]的含义是当决定完第i个物品且背包重量为j时的最大价值
        int[][] dp = new int[n][c + 1];
        //处理第0个物品的状态
        if (w[0] <= c) {
            dp[0][w[0]] = v[0];
        }
        for (int i = 1; i < n; i++) {
            //j是当前背包容量
            for (int j = 1; j <= c; j++) {
                //当前物品重量大于背包容量时不放入背包，继承上一状态结果
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {//当前物品重量小于背包容量时，比较是否放入i时的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n - 1][c];
    }

	/**
	 * 4，动态规划，状态转移方程
	 * dp[j]表示背包容量为j时的最大价值
	 * @param n
	 * @param c
	 * @param w
	 * @param v
	 * @return
	 */
    public int bagPack3(int n, int c, int[] w, int[] v) {
        //dp[j]的含义是背包重量为j时的最大价值
        int[] dp = new int[c + 1];
        //处理第0个物品的状态
        if (w[0] <= c) {
            dp[w[0]] = v[0];
        }
        for (int i = 1; i < n; i++) {
            //j是当前背包容量
            for (int j = c; j >= 1; j--) {
                if (w[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        return dp[c];
    }
}
