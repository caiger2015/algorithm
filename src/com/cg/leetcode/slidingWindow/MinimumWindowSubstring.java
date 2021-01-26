package com.cg.leetcode.slidingWindow;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        int[] tc = new int[256];//t里的字符数量
        int target = 0;
        for (int i = 0; i < t.length(); i++) {
            tc[t.charAt(i)] += 1;
            //t中的不同字符数量，即需要覆盖的字符数量
            if (tc[t.charAt(i)] == 1) {
                target++;
            }
        }
        int[] sc = new int[256];//s里字符数量
        int valid = 0;//标记t中满足匹配条件字符个数
        int l = 0, r = 0;//滑动窗口左右指针
        int len = Integer.MAX_VALUE, lres = 0;//lres表示满足条件的左指针，len表示最小长度，初始设置为Integer.MAX_VALUE
        while (r < s.length()) {
            char c = s.charAt(r);
            sc[c] += 1;
            //窗口中该字符数量等于目标字符数量时，有效覆盖字符数+1
            if (sc[c] == tc[c]) {
                valid++;
            }
            r++;
            //从左侧移除队列中多余的字符
            while (l < r && sc[s.charAt(l)] > tc[s.charAt(l)]) {
                sc[s.charAt(l)] -= 1;
                l++;
            }
            //满足全部覆盖条件时，判断是否最小
            if (valid == target && r - l < len) {
                len = r - l;
                lres = l;
            }
        }
        return len>s.length()? "" : s.substring(lres, lres + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "b"));
    }
}
