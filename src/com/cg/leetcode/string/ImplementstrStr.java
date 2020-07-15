package com.cg.leetcode.string;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param s 被匹配的字符串
	 * @param n 匹配的字符串
	 * @return n在s中第一次出现时s中第一个字符的位置，不存在时返回-1
	 */
	public static int strStr(String s, String n) {
		if (s == null)
			return -1;
		if (n == null || n.length() == 0)
			return 0;
		int i = 0, j = 0;
		int[] next = getNext(n);
		while (i < s.length() && j < n.length()) {
			if (j == -1 || s.charAt(i) == n.charAt(j)) {
				i++;
				j++;
			} else {
				//
				j = next[j];
			}
		}
		if (j == n.length())
			return i - j;
		return -1;
	}

	/**
	 * Description： 确定目标子串每个位置元素的最长前缀匹配子串。
	 * 
	 * @param n
	 *            要匹配的那个串
	 * @return 返回一个next数组，该数组第i个位置的数字表示：当主串和子串比较i位置的元素不通过时， 转而比较next[i]位置的子串元素
	 */
	private static int[] getNext(String n) {
		int[] next = new int[n.length()];
		//-1表示与子串的第一个不匹配，主串后移一位
		next[0] = -1;
		int j = 0, k = -1;
		while (j < n.length() - 1) {
			if (k == -1 || n.charAt(j) == n.charAt(k)) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		// 结合主串和子串匹配过程的改进方法:
		// s[i] != n[j]时需要寻找下一个n中比较的位置，若n[j] == n[k],则s[i] !=
		// n[k],只需要比较s[i]和n[next[k]]
//		if (k==-1 || n.charAt(j) == n.charAt(k)) {
//			j++;
//			k++;
//			if (n.charAt(j) == n.charAt(k))
//				next[j] = next[k];
//			else {
//				next[j] = k;
//			}
//		}
		return next;
	}
}
