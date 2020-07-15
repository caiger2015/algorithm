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
	 * �ʼ��˼·�����ÿ���ָ���ҳ������Ľڵ㣬�������ڵ㴦������ֳ�������ͷ�ĵ�һ��Ϊ�ڵ����·�������������ڵ�
	 * ���·�������ָ��Ĺ��̣�aΪhead����ڽڵ㣬bΪ�����һ���������ڵ㣬cΪ������һ��������ڻ��е���һ�� q = 2s,q =
	 * a+b+n(c+b),a=(n-1)(b+c)+c,
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		//����ָ�����м�ڵ㣬��ʼλ�ö�Ϊhead���Դ�������<=2�ı߽����
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
		// ����c�����������ڵ����ڽڵ㣬����a������ڽڵ�
		quick = quick.next.next;//�ҵ�һ�����
		while (head != quick) {
			head = head.next;
			quick = quick.next;
		}
		return head;
		// �������ڵ㴦������ת��ΪѰ������ͷ�ڵ�������ڵ�����
		// �ڶ�·��ͷ���Ӧ����slow����һ���ڵ㣬slow����·�Ĺ���β���
		// return findNode(slow.next,head,c,s);
	}

	/**
	 * @param slow
	 *            ���������Ľڵ����һ���ڵ㣬�����ڵ�����·��β���
	 * @param head
	 * @param c
	 *            ���н������Ҳ�ǵڶ�·����Ľڵ���
	 * @param s
	 *            ��һ·����Ľڵ���
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
