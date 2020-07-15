package com.cg.leetcode.math;

/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @author caiger
 */
public class PalindromeLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int temp = x, len = 1;
		// ȡ�ȣ�lenΪpow(10��x��λ��-1)
		while (temp >= 10) {
			len *= 10;
			temp /= 10;
		}
		while (x > 0) {
			int high = x / len;
			int low = x % 10;
			if (low != high)
				return false;
			x /= 10;
			x -= high * len;
			len /= 100;
		}
		return true;
	}
}
