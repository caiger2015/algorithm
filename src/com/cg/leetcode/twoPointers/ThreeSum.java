package com.cg.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int target = 0 - cur;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while (i + 1 < nums.length && nums[i + 1] == cur) {
                        i++;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - cur;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while (l < r  && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        res.toString();
        return res;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        System.out.println(deserialize(str));
    }
    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("[");
        if(root==null){
            return res.append("]").toString();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.append(root.val);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left==null){
                res.append(",null");
            }else{
                queue.offer(cur.left);
                res.append(","+cur.left.val);
            }
            if(cur.right==null){
                res.append(",null");
            }else{
                queue.offer(cur.right);
                res.append(","+cur.right.val);
            }
        }
        return res.append("]").toString();
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null||data.length()<=2){
            return null;
        }
        String[] array = data.substring(1, data.length()-1).split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode first = new TreeNode(Integer.valueOf(array[0]));
        queue.offer(first);
        int i=1;
        while(i<array.length){
            TreeNode cur = queue.poll();
            if(i<array.length&&!array[i].equals("null")){
                TreeNode left = new TreeNode(Integer.valueOf(array[i]));
                queue.offer(left);
                cur.left=left;
            }
            i++;
            if(i<array.length&&!array[i].equals("null")){
                TreeNode right = new TreeNode(Integer.valueOf(array[i]));
                queue.offer(right);
                cur.right=right;
            }
            i++;
        }
        return first;
    }
}
