package com.cg.leetcode.slidingWindow;

import java.util.LinkedList;

/**
 * @author caigen
 * 单调栈
 */
public class largestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        int n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int left;
        for (int i = 0; i < n; i++) {
            //单调递增栈，对于第i个元素，将大于它的元素出栈，保证栈单调
            //当元素出栈时，栈顶元素left到i之间的元素都是大于等于该出栈元素的(左右开区间)，故以它为高的矩形大小为heights[pop]*(i-left-1)
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int pop = stack.pop();
                left = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - left - 1) * heights[pop];
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        //遍历完成后，栈中元素单调递增，右边界为n
        while(!stack.isEmpty()){
            int pop = stack.pop();
            left = stack.isEmpty()?-1:stack.peek();
            int area = (n - left - 1) * heights[pop];
            res = Math.max(res, area);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[2];
        nums[0] = 2;
        nums[1] = 3;
//        nums[2] = 5;
//        nums[3] = 6;
//        nums[4] = 2;
//        nums[5] = 3;
        System.out.println(largestRectangleArea(nums));
    }

}
