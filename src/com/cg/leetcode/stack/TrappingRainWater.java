package com.cg.leetcode.stack;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(trap(new int[] { 8, 2, 8, 9, 0, 1, 7, 7, 9 }));
	}

	/*
	 * ˼·�������ж�ÿ��һ���ı仯����̬��˼���仯���̣��ҵ����ޣ��ٽ磩�ĵط�
	 */
	public static int trap(int[] A) {
		// �жϿյ����[]
		if (A.length < 3)
			return 0;
		int high = 0;
		int highindex = 0;
		int res = 0;
		/*
		 * �ҵ���������Ϊ�ٽ�ֵ�� �����߿��ǣ�������high֮ǰ��ÿһ���仯�����Լ򵥵Ŀ��� ������high֮��ֹͣ
		 */
		for (int i = 0; i < A.length; i++) {
			if (high < A[i]) {
				high = A[i];
				highindex = i;
			}
		}
		/*
		 * �ȴ���߿�ʼÿһ�����ǣ� ˫ָ��һ��ָ����߽�left����һ��ָ��i ֻ�е�i>leftʱ��������߽磬
		 * ��Ϊ�Ѿ��ҵ���high������������high֮ǰ��left<high ���Ե�������ÿһ��
		 */
		int left = A[0];
		for (int i = 0; i < highindex; i++) {
			if (left > A[i])
				res += left - A[i];
			else {
				left = A[i];
			}
		}
		int right = A[A.length - 1];
		for (int j = A.length - 1; j > highindex; j--) {
			if (right > A[j])
				res += right - A[j];
			else {
				right = A[j];
			}
		}
		return res;
	}

	// �����˼·��̫���鷳�ˣ�������
	public static int trap1(int[] A) {
		Stack<Integer> left = new Stack<Integer>();
		int res = 0;
		int l = 0;
		int r = 0;
		/*
		 * �ҵ���һ����߽�,��һ���½��ĵط�
		 */
		if (A.length <= 2)
			return 0;
		while (A[r] <= A[r + 1] && r < A.length - 2)
			r++;
		l = r;
		left.push(r);
		if (l >= A.length - 2)
			return 0;
		for (r += 2; r < A.length; r++) {
			if (A[r - 1] < A[r]) {
				if (left.empty())
					continue;
				if (A[r] < A[left.peek()]) {
					for (int j = left.peek() + 1; j < r; j++)
						res += (A[r] - A[j]);
				} else {
					res += A[left.peek()] - A[r - 1];
					int temp = A[left.pop()];
					while (!left.empty() && A[left.peek()] <= A[r]) {
						res += (r - left.peek() - 1) * (A[left.peek()] - temp);
						temp = left.pop();
					}
					if (!left.empty()) {
						res += (r - left.peek() - 1) * (A[r] - temp);
					}
				}
			} else {
				left.push(r - 1);
			}
		}
		return res;
	}
}
