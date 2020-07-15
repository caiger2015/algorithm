package com.cg.leetcode.math;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(titleToNumber("AB"));
	}

	public static int titleToNumber(String s) {
		int res = 0;
		int n = s.length();
		for (int j = 0; j < n; j++) {
			res = res * 26 + (s.charAt(j) - 'A' + 1);
		}
		return res;
	}
}
