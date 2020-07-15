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

	// new����ͷ���ֱ���x���ߵ�����Ȼ�����������������ע�ⷵ�ؽڵ��β���ָ���
	public static ListNode partition3(ListNode head, int x) {
		// ͷָ����
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

	// �ҵ�ͷ���head��β�ڵ�tail�ͽ����n����������>=x�Ľ�����β��㣬ע�Ᵽ�������ϣ�β������ָ��null
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

	// ���õݹ飬ÿ���ҵ���һ��<x�Ľ�㣬��>=x�Ľ�����β�������β���ָ��
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode tail = head;
		// ��ȡĩβ�ڵ�
		while (tail.next != null) {
			tail = tail.next;
		}
		// �ݹ��ȡ��һ���ڵ㹹�����������ڴ�ᳬ��
		ListNode res = getNext(head, x, tail);
		return res;
	}

	/**
	 * @param head
	 *            ��ǰͷ���
	 * @param x
	 *            Ҫ�Ƚϵ�ֵ
	 * @param tail
	 *            ��ǰβ���
	 * @return
	 */
	private static ListNode getNext(ListNode head, int x, ListNode tail) {
		if (head == null)
			return head;
		// ѭ�������ı߽�������head�ٴ�ָ��ͷ�ڵ㣬�����нڵ��ֵ������x
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
