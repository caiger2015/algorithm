package com.cg.leetcode.math;

public class AddBinary {

	public static void main(String[] args) {
		Solution3 sl = new Solution3();
		String out = sl.addBinary("100", "110010");
		System.out.print(out);
		// TODO Auto-generated method stub
	}

}

class Solution3 {
	public String addBinary(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int len3 = len1 > len2 ? len1 : len2;
		StringBuffer result = new StringBuffer(len3 + 1);
		Character temp = '0';
		int j = 1;
		for (; j <= (len1 > len2 ? len2 : len1); j++)// ?:三目运算符
		{
			Character aa = a.charAt(len1 - j);
			Character bb = b.charAt(len2 - j);
			switch (aa + bb + temp)// Character类型 + - > < +
									// 运算，转换成int类型的assc码，0对应48，
			{
			case 147:
				// str = '1'+str的形式可以在前边添加，不用翻转
				result.append('1');
				temp = '1';
				continue;// continue 到达最内的for，break跳出switch继续执行
			case 146:
				result.append('0');
				temp = '1';
				continue;
			case 145:
				result.append('1');
				temp = '0';
				continue;
			case 144:
				result.append('0');
				temp = '0';
				continue;
			}
		}
		while (j <= len1) {
			switch (a.charAt(len1 - j) + temp) {
			case 96:
				result.append('0');
				temp = '0';
				break;// 使用while时，必须对每一个case设有break或者continue！！
			case 97:
				result.append('1');
				temp = '0';
				break;
			case 98:
				result.append('0');
				temp = '1';
				break;
			}
			j++;

		}
		while (j <= len2) {
			switch (b.charAt(len2 - j) + temp) {
			case 96:
				result.append('0');
				temp = '0';
				break;
			case 97:
				result.append('1');
				temp = '0';
				break;
			case 98:
				result.append('0');
				temp = '1';
				break;
			}
			j++;
		}
		if (temp == '1')
			result.append('1');
		return result.reverse().toString();
		// StringBuffer.reverse()翻转字符串，对空着的部分不考虑，
		// 例如大小为3的StringBuffer,存入‘1’，翻转后还是‘1’
	}

}
/*
 * int flag = 0; 7 8 int aIndex = a.size() - 1; 9 int bIndex = b.size() - 1; 10
 * 11 string c; 12 13 while(aIndex >= 0 && bIndex >= 0) 14 { 15 int num =
 * a[aIndex] - '0' + (b[bIndex] - '0') + flag; 16 flag = num / 2; 17 num %= 2;
 * 18 19 c = (char)(num + '0') + c; 20 21 aIndex--; 22 bIndex--; 23 } 24 25
 * while(aIndex >= 0) 26 { 27 int num = a[aIndex] - '0' + flag; 28 flag = num /
 * 2; 29 num %= 2; 30 31 c = (char)(num + '0') + c; 32 33 aIndex--; 34 } 35 36
 * while(bIndex >= 0) 37 { 38 int num = b[bIndex] - '0' + flag; 39 flag = num /
 * 2; 40 num %= 2; 41 42 c = (char)(num + '0') + c; 43 44 bIndex--; 45 } 46 47
 * if (flag > 0) 48 c = (char)(flag + '0') + c; 49 50 return c;
 */