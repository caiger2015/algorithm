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
		// ���ÿ���ָ�����һ������ѭ����ֹʱslow�ں�벿������ĵ�һ����
		while (quick != null) {
			slow = slow.next;
			quick = quick.next;
			if (quick == null)
				break;
			quick = quick.next;
		}
		// ��ת��벿������
		ListNode pre = null, cur = slow;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		// �Ƚ����������Ƿ񹹳ɻ��Ľṹ
		ListNode p = pre, q = head;
		while (p != null && q != null) {
			if (p.val != q.val)
				break;
			p = p.next;
			q = q.next;
		}
		// �ع���ԭ��������ṹ
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
