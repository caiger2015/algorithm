package com.cg.leetcode.stack;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(trap(new int[] { 8, 2, 8, 9, 0, 1, 7, 7, 9 }));
	}

	/*
	 * 思路：依次判断每进一步的变化，动态的思考变化过程，找到极限（临界）的地方
	 */
	public static int trap(int[] A) {
		// 判断空的情况[]
		if (A.length < 3)
			return 0;
		int high = 0;
		int highindex = 0;
		int res = 0;
		/*
		 * 找到最大的数即为临界值， 分两边考虑，在遇到high之前的每一步变化都可以简单的考虑 当遇到high之后，停止
		 */
		for (int i = 0; i < A.length; i++) {
			if (high < A[i]) {
				high = A[i];
				highindex = i;
			}
		}
		/*
		 * 先从左边开始每一步考虑， 双指针一个指向左边界left，另一个指向i 只有当i>left时，更新左边界，
		 * 因为已经找到了high，所以在遇到high之前，left<high 可以单独考虑每一步
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

	// 错误的思路，太过麻烦了！！！！
	public static int trap1(int[] A) {
		Stack<Integer> left = new Stack<Integer>();
		int res = 0;
		int l = 0;
		int r = 0;
		/*
		 * 找到第一个左边界,第一次下降的地方
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
