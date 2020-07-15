/**
 * �������⣺n����Ψһ����ͬ��ֵ��ͬ��������Ʒ��������c�ı������������ֵ
 * @caiger
 */
package com.cg.leetcode.dynamicProgramming;

public class Bagpack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = new Bagpack().bagpack(2, 2, new int[] { 3, 2 }, new int[] { 1,
				2 });
		System.out.print(x + "");
	}

	public int bagpack(int n, int c, int[] w, int[] v) {
		int[][] res = new int[n][c + 1];// ֮ǰ�����СΪ[n][c],��w[j] = i
		for (int[] i : res) { // ���������Ʒ������������Ҫ��������
			for (int j = 0; j < i.length; j++) { // �����±�����
				i[j] = 0;
			}
		}

		for (int i = 1; i <= c; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					// if(w[j]>i+1)//����i+1������
					if (w[j] > i) {
						res[j][i] = 0;
					} else {
						res[j][i] = v[j];
					}
				} else {
					/*
					 * if(w[j]>i)//�������ж���ŵģ�������©��һ�����w[j] = i+1 { if(w[j] ==
					 * i+1&&res[j-1][i] == 0) res[j][i] = v[j]; else{ res[j][i]
					 * = res[j-1][i]; } }
					 */
					if (w[j] > i) {
						res[j][i] = res[j - 1][i];
					} else {
						res[j][i] = res[j - 1][i] > (res[j - 1][i - w[j]] + v[j]) ? res[j - 1][i]
								: res[j - 1][i - w[j]] + v[j];
					}
				}
			}
		}
		return res[n - 1][c];
	}
}
