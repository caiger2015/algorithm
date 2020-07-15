package com.cg.leetcode.linkedList;

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * 如果相交，那么末尾节点必然相同，记录下各自的长度，相差（|lenA-lenB|步遍历就可相遇
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lenA = 1, lenB = 1;
		ListNode p = headA;
		ListNode q = headB;
		while (p.next != null) {
			lenA++;
			p = p.next;
		}
		while (q.next != null) {
			lenB++;
			q = q.next;
		}
		if (q != p)
			return null;
		int temp = Math.abs(lenA - lenB);
		if (lenA < lenB) {
			p = headB;
			q = headA;
		} else {
			p = headA;
			q = headB;
		}
		for (int i = 0; i < temp; i++)
			p = p.next;
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return q;
	}

	/*
	 * 不好的思路
	 */
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p = headA;
		ListNode q = headB;
		while (p.next != null && q.next != null)// 找出长的那个链表
		{
			p = p.next;
			q = q.next;
		}
		if (p.next == null)// 始终把p设成长的那个，对称性问题的考虑思路，只考虑一种情况
		{
			p = headB;
			q = headA;
		}
		for (int i = 0;; i++) {
			for (int j = 0; j <= i && p.next != null; j++) {
				p = p.next;
			}
			while (p.next != null && q.next != null) {
				if (p.next == q.next)
					return q.next;
				else {
					p = p.next;
					q = q.next;
				}
			}
			if (p.next == null)
				if (p == q)
					return q;
				else if (q.next != null)
					return null;
		}
	}
}
