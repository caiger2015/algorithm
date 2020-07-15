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
				//��Ӧ��ϵҪ��һ��һ��������û��key�ǲ�����value
				if (map.containsValue(word.toString())) {
					return false;
				} else {
					map.put(a, word.toString());
				}
			} else {
				//�Ƚ��ַ����Ƿ������String��equals������StringBuffer��equals�����Ǽ̳���object�ķ������ȼ��ڡ�==��
				if (!map.get(a).equals(word.toString())) {
					return false;
				}
			}
			i++;j++;
		}
		//s�����һ�����ǿո���������ѭ��ʱj=m+1��i=n
		return i == n && j == m+1 ? true : false;
	}
}
