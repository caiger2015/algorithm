package com.cg.leetcode.stack;

import java.util.Stack;

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (minStack.empty() || minStack.peek() >= x)// 取 = 是为了防止重复
			minStack.push(x);
		stack.push(x);
	}

	public void pop() {
		// 或者用if(stack.peek().equals(minStack.peek()))
		// peek()返回的是Integer对象，直接比较是比较引用
		if (stack.peek().intValue() == minStack.peek().intValue())
			minStack.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
/*
 * 思路错误 class MinStack { private Node<Integer> top; public MinStack(){ this.top
 * = null; } public void push(int x) { top = new Node<Integer>(new
 * Integer(x),top); }
 * 
 * public void pop() { if(top == null) return; top = top.next; }
 * 
 * public int top() { if (top == null) return -1; return
 * this.top.data.intValue(); }
 * 
 * public int getMin() { if (top == null) return -1; Node<Integer> temp = top;
 * while(temp.next != null){ if(temp.data<= temp.next.data) temp.next =
 * temp.next.next; else temp = temp.next; } return temp.data.intValue(); }
 * 
 * } class Node<T>{ T data; Node<T> next; public Node(T data,Node<T> next){
 * this.data = data; this.next = next; } public Node(){ this(null, null); } }
 */
