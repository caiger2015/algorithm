package com.cg.leetcode.linkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. For example: Given 1->2->3->4->5->NULL and k = 2, return
 * 4->5->1->2->3->NULL.
 * 
 * @author caiger
 */
public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(rotateRight(new ListNode("12345"), 3));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		int n = 1;
		ListNode last = head;
		while (last.next != null) {
			n++;
			last = last.next;
		}
		k %= n;
		last.next = head;
		ListNode rotatedLast = head;
		while (n - k > 1) {
			rotatedLast = rotatedLast.next;
			k++;
		}
		ListNode res = rotatedLast.next;
		rotatedLast.next = null;
		return res;
	}
}
