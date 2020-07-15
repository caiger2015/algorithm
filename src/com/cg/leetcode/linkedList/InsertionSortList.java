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
			// 找到插入的位置
			while (cur != null && insertNode.val >= cur.val) {
				pre = cur;
				cur = cur.next;
			}
			// 插入在尾部，尾结点的next为null
			if (cur == null) {
				tail.next = insertNode;
				tail = insertNode;
				insertNode = insertNode.next;
				tail.next = null;
			}
			// 插入在头部
			else if (pre == null) {
				ListNode temp = insertNode.next;
				insertNode.next = head;
				head = insertNode;
				insertNode = temp;
			}
			// 插入在中间
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
