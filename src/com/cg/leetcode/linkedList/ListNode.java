package com.cg.leetcode.linkedList;

/**
 * Definition for single linked list;
 * 
 * @author caiger
 * 
 */
public class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	/**
	 * @param s
	 *            利用字符串构造链表
	 */
	public ListNode(String s) {
		if (s == null || s.length() == 0) {
			return;
		}
		this.val = s.charAt(0) - '0';
		ListNode temp = this;
		for (int i = 1; i < s.length(); i++) {
			temp.next = new ListNode(s.charAt(i) - '0');
			temp = temp.next;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 便利以该节点为头结点的链表并输出
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		ListNode temp = this;
		while (temp != null) {
			sb.append(temp.val + ",");
			temp = temp.next;
		}
		if (sb.length() > 1)
			sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

}
