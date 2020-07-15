/**
 * �ҳ�һ�����е�����һ����˼·��
 * ͳ��������32λÿһλ��1�ĸ����ܺͣ�����һ��32��С�����飬
 * ��K���������Ĵ�����ȡģ������Ϊ1��λ��Ӧ��������һ������
 * ���ת��Ϊint
 * tips:��bitλ�Ĳ���Ӧ��������Сint���������
 */
package com.cg.leetcode.bitManipulation;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 slSolution2 = new Solution2();
		int r = slSolution2.singleNumber(new int[] { -2, -2, 1, 1, -3, 1, -3,
				-3, Integer.MIN_VALUE, -2 });
		System.out.print(r + "");
	}

}

class Solution2 {
	public int singleNumber(int[] A) {
		int[] flag = new int[32];// �洢ÿ��bit
									// ���һλΪ1ʱ��ʾ��Сint -2147483648
		int result = 0;
		int sim = 0;// �洢����
		for (int i = 0; i < A.length; i++) {
			int temp = A[i];
			if (temp < 0)
				sim++;
			for (int j = 0; j < 32 && temp != 0; j++)// maybe negative
			{
				if (temp % 2 != 0)
					flag[j] += 1;
				temp /= 2;
			}
			for (int j = 0; j < 32; j++) {
				flag[j] = flag[j] % 3;
			}
		}
		sim = (int) Math.pow(-1, sim % 3);
		for (int j = 0; j < 32; j++)
			result += flag[j] * (new Double(sim * Math.pow(2, j)).intValue());
		return result;
	}
}