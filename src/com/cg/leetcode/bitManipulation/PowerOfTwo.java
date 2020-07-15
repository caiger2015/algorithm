package com.cg.leetcode.bitManipulation;

/**
 * Given an integer, write a function to determine if it is a power of two. 
 * @author caiger
 */
public class PowerOfTwo {
	// ����������args�����ķ�����run-->run configuration��ѡ���Ӧ���࣬����program arguments
	public static void main(String[] args) {
		String str = args[0];
		int n = Integer.parseInt(str);
		System.out.print(isPowerOfTwo(n));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		int count = 0;
		while (n != 0) {
			if (1 == (n & 1))
				count++;
			n = n >> 1;
		}
		return count > 1 ? false : true;
	}
}
