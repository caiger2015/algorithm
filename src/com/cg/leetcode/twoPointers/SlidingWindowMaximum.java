package com.cg.leetcode.twoPointers;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k <= 1 || n == 1) {
            return nums;
        }
        //用双端队列记录窗口中的元素下标，当前窗口中的元素在位置不变情况下按照单调递减排列
        Deque<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && (nums[i] >= nums[q.peekLast()])) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[q.peekFirst()];
        for (int l = 1, r = k; r < n; l++, r++) {
            int right = nums[r];
            while (!q.isEmpty() && right >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(r);
            while (!q.isEmpty() && q.peekFirst() <= l - 1) {
                q.pollFirst();
            }
            res[l] = nums[q.peekFirst()];
        }
        return res;
    }


}
