package com.cg.leetcode.linkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0, null);
        ListNode cur = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2){
//                return o1.val - o2.val;
//            }
//        });
        queue.addAll(Arrays.asList(lists));
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return head.next;
    }

}
