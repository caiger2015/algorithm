package com.cg.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		// 如果把所有的数都先放在hashmap里面的话，在查找一个数的相加数是，塔本身也在查找范围内，
		// 例如，6-3 = 3，此时会查找到3
		// for(int i = 0;i<nums.length;i++){
		// table.put(nums[i],i+1);
		// }
		// for(int j = 0;j<nums.length;j++){
		// Integer sub = new Integer(target-nums[j]);
		// Integer temp = table.get(sub);
		// if(temp != null){
		// res[0] = j+1;
		// res[1] = temp;
		// break;
		// }
		// }
		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(target - nums[i])) {
				res[0] = table.get(target - nums[i]);
				res[1] = i + 1;
				break;
			} else {
				table.put(nums[i], i + 1);
			}
		}
		return res;
	}
}
