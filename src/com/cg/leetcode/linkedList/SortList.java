package com.cg.leetcode.linkedList;

/**
 * @author caiger 
 * Sort a linked list in O(n log n) time using constant space
 * complexity.
 */
public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l = new ListNode("14734296");
		System.out.print(sortList(l));
	}
	//�鲢�ķ�ʽ�����м�ڵ�ϲ���������
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next==null){
			return head;
		}
		ListNode slow = head;
		ListNode quick = head;
		ListNode last = head;
		//����ָ�����м�ڵ㣬��ʼλ�ö�Ϊhead���Դ�������<=2�ı߽����
		while(quick==head||quick != null){
			last = slow;
			slow = slow.next;
			if(quick.next == null){
				break;
			} else {
				quick = quick.next.next;
			}
		}
		last.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return merge(left, right);		
	}
	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private static ListNode merge(ListNode left, ListNode right) {
		if(left == null){
			return right;
		}
		if(right==null){
			return left;
		}
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode p = head;
		while(left != null&& right!= null){
			if(left.val<=right.val){
				p.next=left;
				left= left.next;
			}else{
				p.next = right;
				right = right.next;
			}
			p=p.next;
		}
		while(left !=null){
			p.next = left;
			p=p.next;
			left=left.next;
		}
		while(right!= null){
			p.next=right;
			p=p.next;
			right=right.next;
		}
		return head.next;
	}
	//���ŵķ�ʽ��time limit exceeded
	public static ListNode sortList1(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode left = new ListNode(Integer.MIN_VALUE);
		ListNode right = new ListNode(Integer.MAX_VALUE);
		ListNode tail = head;
		while(tail.next!=null){
			tail=tail.next;
		}
		left.next=head;
		tail.next=right;
		quickSort(left,right);
		ListNode temp = left;
		while(temp.next!=right){
			temp=temp.next;
		}
		temp.next=null;
		return left.next;
	}

	/**
	 * @param left
	 * @param right
	 */
	private static void quickSort(ListNode left, ListNode right) {
		if(left.next==right){
			return;
		}
		ListNode next = left.next;
		ListNode ltail = left;
		ListNode rtail = next;
		ListNode temp = next.next;
		while(temp!=right){
			if(temp.val<next.val){
				ltail.next=temp;
				ltail=ltail.next;
			}else{
				rtail.next=temp;
				rtail=rtail.next;
			}
			temp = temp.next;
		}
		ltail.next = next;
		rtail.next = right;
		quickSort(left, next);
		quickSort(next, right);
	}
}
