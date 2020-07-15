package com.cg.leetcode.stack;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = isValid("([])");
		boolean b = isMatch('(', '(');
		System.out.print(a + " " + b);
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		// for(int i = 0;i<s.length();i++){
		// if(stack.isEmpty())
		// stack.push(s.charAt(i));
		// else if(!isMatch(stack.pop(),s.charAt(i)))
		// return false;
		// }
		int j = 0;
		while (j < s.length()) {
			if (stack.isEmpty() || s.charAt(j) == '(' || s.charAt(j) == '['
					|| s.charAt(j) == '{') {
				stack.push(s.charAt(j++));
			} else if (!isMatch(stack.pop(), s.charAt(j++))) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatch(char a, char b) {
		return a == '(' && b == ')' || a == '{' && b == '}' || a == '['
				&& b == ']';
	}

}
