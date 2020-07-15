package com.cg.leetcode.math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution4 sl = new solution4();
		System.out.print(sl.convertToTitle(1000000001));
	}

}

class solution4 {
	// �����󡣡�����
	public String convertToTitle1(int n) {
		String sim = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String res = "";
		int i = 0;
		int j = (n - 1) % 26;// (n-1)Ϊ�˺ö�ȡ�ַ���
		while (i + 1 <= (n - 1) / 26)// ���n-1)��Ϊ�˱�֤26�������������ȷ
										// ��Ϊi��ǵ�����λ��-1
		{
			res += sim.charAt(i % 26);// ��26ȡ�࣬��֤����26λ����Ȼ�����
			i++;
		}
		res += sim.charAt(j);
		return res;
	}

	public String convertToTitle(int n) {
		// String sim = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String res = "";
		while (n > 0) {
			// res = sim.charAt((n-1)%26)+res;
			// ������Ϊint���ͣ���ʾasc2��ֵ��ǿ��ת��Ϊchar
			char c = (char) ((n - 1) % 26 + 'A');
			res = c + res;
			n = (n - 1) / 26;
		}
		return res;

	}
}
