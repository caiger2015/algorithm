package com.cg.leetcode.bitManipulation;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

class Solution {
	public int singleNumber1(int[] A) {
		int x = 0;
		for (int i = 0; i < A.length; i++) {
			x = x ^ A[i];// ���������ת���ɶ����Ʋ���������ģ�
							// a^b = b^a,a^b^c = a^(b^c),0^a = a
		}
		return x;
	}
}
