package com.cg.leetcode.hashTable;

import java.util.HashMap;

/**
 * @author caiger
 *
 */
public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(wordPattern("abba", "s t t s"));
	}

	public static boolean wordPattern(String p, String s) {
		if (p == null && s == null)
			return true;
		if (p == null || s == null) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
		int i = 0, j = 0, n = p.length(), m = s.length();
		while (i < n && j < m) {
			char a = p.charAt(i);
			StringBuffer word = new StringBuffer();
			while (j < m && s.charAt(j) != ' ') {
				word.append(s.charAt(j++));
			}
			if (!map.containsKey(a)) {
				//对应关系要求一对一，反过来没有key是不能有value
				if (map.containsValue(word.toString())) {
					return false;
				} else {
					map.put(a, word.toString());
				}
			} else {
				//比较字符串是否相等用String的equals方法，StringBuffer的equals方法是继承自object的方法，等价于“==”
				if (!map.get(a).equals(word.toString())) {
					return false;
				}
			}
			i++;j++;
		}
		//s的最后一个不是空格，所以跳出循环时j=m+1，i=n
		return i == n && j == m+1 ? true : false;
	}
}
