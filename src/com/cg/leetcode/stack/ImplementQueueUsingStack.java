package com.cg.leetcode.stack;

import java.util.LinkedList;

/**
 * @author caiger
 *
 */
public class ImplementQueueUsingStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue que = new MyQueue();
		que.push(1);
		que.push(2);
		que.pop();
		que.push(3);
		que.push(4);
		que.pop();
		System.out.print(que.peek());
	}

}

class MyQueue {
	LinkedList<Integer> top = new LinkedList<Integer>();
	LinkedList<Integer> data = new LinkedList<Integer>();

	// ����stack���Ի�˳������ã�
	// topջ����queue��˳��洢���ݣ�dataջ����stack��˳��洢���ݣ�ÿ��top��û������ʱ����data�е����ݵ���top�С�
	// Push element x to the back of queue.
	public void push(int x) {
		data.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!top.isEmpty())
			top.pop();
		else {
			while (!data.isEmpty()) {
				top.push(data.pop());
			}
			top.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (!top.isEmpty()) {
			return top.peek();
		} else {
			while (!data.isEmpty()) {
				top.push(data.pop());
			}
			return top.peek();
		}
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return top.isEmpty() && data.isEmpty();
	}
}