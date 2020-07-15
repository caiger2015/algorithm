package com.cg.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c  =  0?
 * Find all unique triplets in the array which gives the sum of zero
 * ����Ѱ��ʱ�临�Ӷ�O(n^3)������Ҫ�����������⣬�����ȴ�����������Arrays.sort();
 * ���ź�������д����Ӷȵ�,���ҿ��ԺܺõĴ����ظ�����
 */
public class Sum3 {

	public void main(String[] args) {
		// TODO Auto-generated method stub
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] num) {
		if (num.length <= 2 || num == null)
			return res;
		Arrays.sort(num);// �������飬������������в���Ч�ʸ�
		int len = num.length;
		for (int i = 0; i < len - 2 && num[i] <= 0; i++) {
			// �ų��ظ��Ľ��
			if (i > 0 && num[i] == num[i - 1])
				continue;
			find(num, i + 1, len - 1, num[i]);
		}
		return res;
	}

	public void find(int[] num, int begin, int end, int target) {
		// ˫ָ��Ѱ�ң���˫��forѭ��ʱ�临�Ӷȵͣ���Ϊ�Ѿ�������
		while (begin < end) {
			if (target + num[begin] + num[end] == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(target);
				ans.add(num[begin]);
				ans.add(num[end]);
				res.add(ans);
				// �ų���ͬ������
				while (begin < end && num[begin] == num[begin + 1])
					begin++;
				while (begin < end && num[end] == num[end - 1])
					end--;
				begin++;
				end--;
			} else if (target + num[begin] + num[end] > 0)
				end--;
			else {
				begin++;
			}
		}
	}
}
