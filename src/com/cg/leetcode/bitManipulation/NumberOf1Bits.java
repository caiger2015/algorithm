package com.cg.leetcode.bitManipulation;

/*
 * Write a function that takes an unsigned integer and returns 
 * the number of ¡¯1' bits it has (also known as the Hamming weight).
 */

public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static int hammingWeight(int n) {
		if (n == Integer.MIN_VALUE)
			return 1;
		int result = 0;
		while (n != 0)// useing " != " to avoid considerring whether n is
						// positive or negtive
		{
			result += n & 1;// checkout the last bit
			n = n >>> 1;// ">>>" the highest bit if filled with 0,instead of 1
						// using >>
		}
		return result;
	}
}
