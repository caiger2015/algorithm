package com.cg.leetcode.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[] { "123", "12" };
		System.out.print(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int n = strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			if (n > strs[i].length())
				n = strs[i].length();
		}
		if (n == 0)
			return "";
		StringBuilder res = new StringBuilder();
		// res.append(strs[0].charAt(0));
		for (int j = 0; j < n; j++) {
			// 放在这里更新res，每次判定res是否最长之前，等效于在判定成功一位之后，切包含了j<n的判定
			res.append(strs[0].charAt(j));
			for (int k = 0; k < strs.length; k++) {
				if (res.charAt(j) != strs[k].charAt(j)) {
					// 删除最后一位，返回res中共同的prefix
					return res.deleteCharAt(j).toString();
				}
			}
			// if(j+1<n)
			// res.append(strs[0].charAt(j+1));
		}
		return res.toString();
	}
}
