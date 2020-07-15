package com.cg.leetcode.twoPointers;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.print(isPalindrome("aA") + "" + isMatch('a', 'A'));
	}

	public static boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (isAlphanumberic(s.charAt(start))
					&& isAlphanumberic(s.charAt(end))) {
				if (!isMatch(s.charAt(start), s.charAt(end)))
					return false;
				else {
					start++;
					end--;
				}
			} else {
				if (!isAlphanumberic(s.charAt(start)))
					start++;
				if (!isAlphanumberic(s.charAt(end)))
					end--;
			}
		}
		return true;
	}

	private static boolean isAlphanumberic(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')
				|| ('0' <= c && c <= '9');
	}

	private static boolean isMatch(char a, char b) {
		if (a == b)
			return true;
		else if (a >= 'A' && a <= 'Z' && a == b - ('a' - 'A'))
			return true;
		else if (a <= 'z' && a >= 'a' && a == b + ('a' - 'A'))
			return true;
		else
			return false;
	}

}
