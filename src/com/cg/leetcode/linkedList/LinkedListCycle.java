package com.cg.leetcode.linkedList;

/**
 *
 * Given a linked list, determine if it has a cycle in it.Follow up:Can you
 * solve it without using extra space?
 * 
 * @author caiger
 */
public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 快慢指针，有环则会相遇
	 * 
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode quick = head;
		ListNode slow = head;
		while (quick == head || quick != null) {
			if (slow == quick)
				return true;
			slow = slow.next;
			if (quick.next == null)
				return false;
			quick = quick.next.next;
		}
		return false;
	}
}
