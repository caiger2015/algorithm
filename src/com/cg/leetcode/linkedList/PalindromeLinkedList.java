package com.cg.leetcode.linkedList;

/**
 * Given a singly linked list, determine if it is a palindrome in O(n) time and
 * O(1) space.
 * 
 * @author caiger
 */
public class PalindromeLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode p = new ListNode("123321");
		System.out.print(isPalindrome(p) + "  " + p);
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode quick = head, slow = head;
		// 利用快慢指针遍历一遍链表，循环终止时slow在后半部分链表的第一个。
		while (quick != null) {
			slow = slow.next;
			quick = quick.next;
			if (quick == null)
				break;
			quick = quick.next;
		}
		// 翻转后半部分链表
		ListNode pre = null, cur = slow;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		// 比较两段链表是否构成回文结构
		ListNode p = pre, q = head;
		while (p != null && q != null) {
			if (p.val != q.val)
				break;
			p = p.next;
			q = q.next;
		}
		// 重构回原来的链表结构
		ListNode pre2 = null;
		while (pre != null) {
			ListNode temp = pre.next;
			pre.next = pre2;
			pre2 = pre;
			pre = temp;
		}
		return p == null || q == null ? true : false;
	}
}
