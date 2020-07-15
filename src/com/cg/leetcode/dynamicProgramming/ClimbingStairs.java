package com.cg.leetcode.dynamicProgramming;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution slSolution = new Solution();
		System.out.print(slSolution.climbStairs(3) + "");
	}

}

class Solution {
	// �õݹ�ķ���ʱ�临�Ӷ�̫�󣡣�
	public int climbStairs1(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return 1;
		else {
			int[] result = new int[n + 1];
			result[0] = 1;
			result[1] = 1;
			for (int i = 2; i <= n; i++) {
				result[i] = result[i - 1] + result[i - 2];
			}
			return result[n];
		}
	}
}
