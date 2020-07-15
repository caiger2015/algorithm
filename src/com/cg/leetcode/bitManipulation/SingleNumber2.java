/**
 * 找出一组数中单独的一个，思路：
 * 统计所有数32位每一位上1的个数总和，存入一个32大小的数组，
 * 对K（其他数的次数）取模，所有为1的位对应单独的那一个数，
 * 最后转化为int
 * tips:对bit位的操作应当考虑最小int的溢出问题
 */
package com.cg.leetcode.bitManipulation;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 slSolution2 = new Solution2();
		int r = slSolution2.singleNumber(new int[] { -2, -2, 1, 1, -3, 1, -3,
				-3, Integer.MIN_VALUE, -2 });
		System.out.print(r + "");
	}

}

class Solution2 {
	public int singleNumber(int[] A) {
		int[] flag = new int[32];// 存储每个bit
									// 最后一位为1时表示最小int -2147483648
		int result = 0;
		int sim = 0;// 存储符号
		for (int i = 0; i < A.length; i++) {
			int temp = A[i];
			if (temp < 0)
				sim++;
			for (int j = 0; j < 32 && temp != 0; j++)// maybe negative
			{
				if (temp % 2 != 0)
					flag[j] += 1;
				temp /= 2;
			}
			for (int j = 0; j < 32; j++) {
				flag[j] = flag[j] % 3;
			}
		}
		sim = (int) Math.pow(-1, sim % 3);
		for (int j = 0; j < 32; j++)
			result += flag[j] * (new Double(sim * Math.pow(2, j)).intValue());
		return result;
	}
}