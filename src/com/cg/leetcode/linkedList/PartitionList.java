package com.cg.leetcode.linkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.You should preserve the
 * original relative order of the nodes in each of the two partitions. For
 * example,Given 1->4->3->2->5->2 and x = 3,return 1->2->2->4->3->5.
 * 
 * @author caiger
 */
public class PartitionList {
	public static void main(String[] args) {
		System.out.print(partition3(new ListNode("26126432527"), 3));
	}

	// new两个头结点分别构造x两边的链表，然后把他们连接起来，注意返回节点和尾结点指向空
	public static ListNode partition3(ListNode head, int x) {
		// 头指针结点
		ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
		ListNode s = smallHead, b = bigHead;
		while (head != null) {
			if (head.val < x) {
				s.next = head;
				s = s.next;
			} else {
				b.next = head;
				b = b.next;
			}
			head = head.next;
		}
		b.next = null;
		s.next = bigHead.next;
		return smallHead.next;
	}

	// 找到头结点head、尾节点tail和结点数n，遍历链表将>=x的结点接在尾结点，注意保持链表不断，尾结点最后指向null
	public static ListNode partition2(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode tail = head;
		int n = 1;
		while (tail.next != null) {
			tail = tail.next;
			n++;
		}
		while (n > 0 && head.val >= x) {
			n--;
			tail.next = head;
			tail = head;
			head = head.next;
		}
		ListNode temp = head, pre = null;
		while (n > 0) {
			n--;
			if (temp.val < x) {
				pre = temp;
				temp = temp.next;
			} else {
				tail.next = temp;
				tail = temp;
				temp = temp.next;
				pre.next = temp;
			}
		}
		tail.next = null;
		return head;
	}

	// 利用递归，每次找到下一个<x的结点，将>=x的结点接在尾部，最后尾结点指空
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode tail = head;
		// 获取末尾节点
		while (tail.next != null) {
			tail = tail.next;
		}
		// 递归获取下一个节点构造链表，但是内存会超标
		ListNode res = getNext(head, x, tail);
		return res;
	}

	/**
	 * @param head
	 *            当前头结点
	 * @param x
	 *            要比较的值
	 * @param tail
	 *            当前尾结点
	 * @return
	 */
	private static ListNode getNext(ListNode head, int x, ListNode tail) {
		if (head == null)
			return head;
		// 循环结束的边界条件是head再次指向头节点，即所有节点的值均大于x
		ListNode end = tail;
		while (head != end && head.val >= x) {
			tail.next = head;
			tail = head;
			head = head.next;
		}
		if (head == end) {
			if (head.val <= x) {
				return head;
			} else {
				tail.next = head;
				tail = head;
				head = head.next;
				tail.next = null;
				return head;
			}
		} else {
			head.next = getNext(head.next, x, tail);
		}
		return head;
	}

}
