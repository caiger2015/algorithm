package com.cg.leetcode.string;

/*
 * The count-and-say sequence is the sequence of integers beginning 
 * as follows:
 1, 11, 21, 1211, 111221, ...
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 */
public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countAndSay(1));
	}

	public static String countAndSay(int n) {
		// if(n == 0)
		// return "";
		StringBuilder result = new StringBuilder("1");// 第一个
		for (int i = 0; i < n - 1; i++)// 剩下的n-1个
		{
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < result.length();) {
				int k = 1;
				while (j < result.length() - 1
						&& result.charAt(j) == result.charAt(j + 1)) {
					j++;
					k++;
				}
				temp.append(k);
				temp.append(result.charAt(j));
				j++;
			}
			result = temp;
		}
		return result.toString();
	}
}
