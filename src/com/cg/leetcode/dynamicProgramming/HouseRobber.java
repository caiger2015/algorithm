package com.cg.leetcode.dynamicProgramming;

/*
 * ��̬�滮���⣬ת��Ϊ���ɸ����Ƶ������⣬
 * �ҳ����ƹ�ʽ��ȷ����ʼ���������˳����׶εĽ��ֱ�����
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(int[] num) {
		int len = num.length;
		int[] res = new int[len];
		// ���ֳ���Ϊ�㣬��һ���������Ԫ�صĶ��󣬷���ʱ����Ҫ�ж�
		// int[] A = null; ��ʾA������Ϊ�գ�����ʱҪ�ж��Ƿ�Ϊ��
		if (len == 0)
			return 0;
		if (len == 1)
			return num[0];
		if (len == 2)
			return Math.max(num[0], num[1]);
		res[0] = num[0];
		res[1] = Math.max(num[1], num[0]);

		for (int i = 2; i < len; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + num[i]);
		}
		return res[len - 1];
	}
}
