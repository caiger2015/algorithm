package com.cg.leetcode.linkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null
 * 
 * @author caiger
 */
public class LinkedListCycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 最开始的思路：利用快慢指针找出相遇的节点，在相遇节点处把链表分成有两个头的点一个为节点的两路链表，求其相遇节点
	 * 重新分析快慢指针的过程，a为head到入口节点，b为入口下一个到相遇节点，c为相遇下一个到入口在环中的上一个 q = 2s,q =
	 * a+b+n(c+b),a=(n-1)(b+c)+c,
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		//快慢指针找中间节点，起始位置都为head可以处理结点数<=2的边界情况
		ListNode slow = head;
		// ListNode quick = head.next.next;
		// while (quick != null) {
		ListNode quick = head;
		while (quick == head || quick != null) {
			if (quick == slow)
				break;
			slow = slow.next;
			if (quick.next == null)
				return null;
			quick = quick.next.next;
		}
		if (quick == null)
			return null;
		// 长度c不包含相遇节点和入口节点，长度a包含入口节点
		quick = quick.next.next;//找第一个结点
		while (head != quick) {
			head = head.next;
			quick = quick.next;
		}
		return head;
		// 在相遇节点处把问题转化为寻找两个头节点的相遇节点问题
		// 第二路的头结点应该是slow的下一个节点，slow是两路的公共尾结点
		// return findNode(slow.next,head,c,s);
	}

	/**
	 * @param slow
	 *            环中相遇的节点的下一个节点，相遇节点是两路的尾结点
	 * @param head
	 * @param c
	 *            环中结点数，也是第二路链表的节点数
	 * @param s
	 *            第一路链表的节点数
	 * @return
	 */
	@SuppressWarnings("unused")
	private ListNode findNode(ListNode slow, ListNode head, int c, int s) {
		int diff = Math.abs(c - s);
		ListNode first, second;
		if (c < s) {
			first = head;
			second = slow;
		} else {
			first = slow;
			second = head;
		}
		while (diff > 0) {
			first = first.next;
			diff--;
		}
		while (first != second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
}
