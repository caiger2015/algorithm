package com.cg.leetcode.linkedList;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author caiger
 * 
 */
public class InsertionSortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode insertNode = head.next;
		ListNode tail = head;
		tail.next = null;
		while (insertNode != null) {
			ListNode cur = head, pre = null;
			// �ҵ������λ��
			while (cur != null && insertNode.val >= cur.val) {
				pre = cur;
				cur = cur.next;
			}
			// ������β����β����nextΪnull
			if (cur == null) {
				tail.next = insertNode;
				tail = insertNode;
				insertNode = insertNode.next;
				tail.next = null;
			}
			// ������ͷ��
			else if (pre == null) {
				ListNode temp = insertNode.next;
				insertNode.next = head;
				head = insertNode;
				insertNode = temp;
			}
			// �������м�
			else {
				ListNode temp = insertNode.next;
				pre.next = insertNode;
				insertNode.next = cur;
				insertNode = temp;
			}
		}
		return head;
	}
}
