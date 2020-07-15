package com.cg.leetcode.math;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isHappyNumber(7));
	}

	public static boolean isHappyNumber(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (set.add(n)) {
			int temp = n, res = 0;
			while (temp > 0) {
				// 这个是去比特位末位的
				// res += (temp&1)*(temp&1);
				res += (temp % 10) * (temp % 10);
				temp /= 10;
			}
			n = res;
		}
		return n == 1;
	}

}
