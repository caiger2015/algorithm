package com.cg.leetcode.linkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. For example,Given
 * 1->2->3->3->4->4->5, return 1->2->5.Given 1->1->1->2->3, return 2->3.
 * 
 * @author caiger
 *
 */
public class RemoveDuplicatesfromSortedList2 {

	public static void main(String[] args) {
		System.out.print(deleteDuplicates(new ListNode("11")));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next, res = null;
		int dup = head.val;
		if (cur.val != dup) {
			res = head;
		} else {
			while (cur != null) {
				if (cur.val == dup) {
					cur = cur.next;
				} else if (cur.next == null) {
					return cur;
				} else if (cur.next.val == cur.val) {
					dup = cur.val;
					cur = cur.next.next;
				} else {
					res = cur;
					cur=cur.next;
					break;
				}
			}
		}
		if(res!=null)
			res.next=deleteDuplicates(cur);
		return res;
	}
}
