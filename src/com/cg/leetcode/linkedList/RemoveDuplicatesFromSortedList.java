package com.cg.leetcode.linkedList;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. For example, Given 1->1->2, return 1->2. Given
 * 1->1->2->3->3, return 1->2->3.
 * 
 * @author caiger
 */
public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {

	}

	public ListNode removeDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		ListNode pre = head;
		while (cur != null) {
			if (cur.val == pre.val) {
				cur = cur.next;
				pre.next = cur;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}

}
