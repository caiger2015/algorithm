package com.cg.leetcode.stack;

import java.util.LinkedList;

/**
 * @author caiger
 *
 */
public class ImplementStackUsingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}

class MyStack {
	private LinkedList<Integer> tempQue = new LinkedList<Integer>();
	private LinkedList<Integer> topQue = new LinkedList<Integer>();

	// Push element x onto stack.
	// 这种方法虽然思路简单，但是考虑到stack作为容器的功能，push用到的会比pop多，所以应该进行改进，方式见implement stack
	// using queue
	public void push(int x) {
		while (!topQue.isEmpty()) {
			tempQue.add(topQue.poll());
		}
		topQue.add(x);
		while (!tempQue.isEmpty()) {
			topQue.add(tempQue.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		topQue.poll();
	}

	// Get the top element.
	public int top() {
		return topQue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return topQue.isEmpty();
	}
}
