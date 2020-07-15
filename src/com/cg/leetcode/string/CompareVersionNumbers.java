package com.cg.leetcode.string;

/**
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0. You may
 * assume that the version strings are non-empty and contain only digits and the
 * . character. The . character does not represent a decimal point and is used
 * to separate number sequences. For instance, 2.5 is not "two and a half" or
 * "half way to version three", it is the fifth second-level revision of the
 * second first-level revision. Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author caiger
 */
public class CompareVersionNumbers {
	public static void main(String[] args) {
		System.out.print(compareVersion("01.01.000.0", "1.1"));
	}

	/**
	 * description���á�."���ָ����Ӱ汾��ͬ���İ汾��֮��Ƚϴ�С����ͬ������Ƚ���һ����
	 * ע�⴦��ð汾���еġ�0������ͷ����β��������ȫ0�汾��01.01.000.00 == 1.1��
	 * 
	 * @param v1
	 *            Ҫ�Ƚϵ��ַ���
	 * @param v2
	 *            Ҫ�Ƚϵ��ַ���
	 * @return v1>v2 ����1��v1<v2����-1�����򷵻�0
	 */
	public static int compareVersion(String v1, String v2) {
		if (v1 == null || v2 == null)
			return 0;
		int n = v1.length();
		int m = v2.length();
		int i = 0, j = 0;
		while (i < n && j < m) {
			int t1 = 0;
			while (i < n && v1.charAt(i) != '.') {
				t1 = t1 * 10 + v1.charAt(i) - '0';
				i++;
			}
			int t2 = 0;
			while (j < m && v2.charAt(j) != '.') {
				t2 = t2 * 10 + v2.charAt(j) - '0';
				j++;
			}
			if (t1 == t2) {
				i++;
				j++;
				continue;
			}
			if (t1 < t2)
				return -1;
			if (t1 > t2)
				return 1;
		}
		// ѭ�������ֱ������������������δ��ͷ�Ĳ����Ƿ�汾ȫ��0
		while (i < n && (v1.charAt(i) == '0' || v1.charAt(i) == '.'))
			i++;
		while (j < m && (v2.charAt(j) == '0' || v2.charAt(j) == '.'))
			j++;
		if (i < n)
			return 1;
		if (j < m)
			return -1;
		return 0;
	}

}
