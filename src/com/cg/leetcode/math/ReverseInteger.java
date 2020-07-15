/**
 * 
 */
package com.cg.leetcode.math;

import java.util.Stack;

public class ReverseInteger {

	public static void main(String[] args) {
		Solution sl = new Solution();
		System.out.println(sl.reverse3(Integer.MIN_VALUE));
	}
}

class Solution {
	private Stack<Character> stack = new Stack<Character>();
	private StringBuffer result;

	// 用栈处理太过复杂，栈是用来控制优先级的
	public int reverse(int x) {

		String str = Integer.toString(x);
		int i = 0, sim = 0;
		if (str.charAt(0) == '-') {
			sim = -1;
			i++;
		}
		if (str.charAt(0) == '+') {
			sim = 1;
			i++;
		}
		// 这里出过错，因为else对应的是上一个if，所以如果上一条不成立，
		// 会对sim重新赋值
		// else {
		// sim = 1;
		// }
		// StringBuffer使用时要初始化大小
		result = new StringBuffer(str.length() - i);
		for (; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		while (!stack.isEmpty())
			result.append(stack.pop());
		double db = Double.valueOf(result.toString());
		if (db * sim > Integer.MAX_VALUE || db * sim < Integer.MIN_VALUE)
			return 0;
		return (int) db * sim;
	}

	// 转换成StringBuffer来处理消耗资源太多
	public int reverse2(int x) {
		int sim = 0;
		if (x < 0)
			sim = -1;
		else
			sim = 1;
		// double result = x*sim;
		// 这里double是双进度浮点数，转换成String是"xxx.0"
		// 所以reverse（）之后是“0.xxx”
		long result = (long) x * sim;// 需要显示转换，否则还是会溢出
		StringBuffer str = new StringBuffer(result + "");
		// StringBuffer str = new StringBuffer(x*sim+"");
		// tip：当x = int最小值时，它的绝对值是int最大值+1，溢出了！
		StringBuffer str1 = str.reverse();
		result = Long.valueOf(str1.toString());
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		return (int) result * sim;

	}

	// 考虑用数学方法来处理，因为数字本身就是排序的，
	// 所以只需要考虑好符号和溢出问题就可以了
	// 用循环来解决问题
	public int reverse3(int x) {
		long res = 0;
		if (x == Integer.MIN_VALUE)
			return 0;
		int temp = Math.abs(x);
		while (temp > 0) {
			res = res * 10 + temp % 10;// 取余方式取最后一位
			temp /= 10;// 舍去最后一位
		}
		if (res > Integer.MAX_VALUE)
			return 0;

		if (x > 0)
			return (int) res;
		return (int) res * -1;

	}

}