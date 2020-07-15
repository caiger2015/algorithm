package com.cg.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class PascalTriangle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(generate(5).toString());
	}
	public static List<Integer> generate(int rowIndex){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] res = new int[rowIndex+1];
		int pre;
		for(int i = 1;i<= rowIndex+1;i++){
			pre = 1;
			for(int j = 0;j<i;j++){
				if(j == 0||j == i-1)
					res[j] = 1;
				else{
					int temp = res[j];
					res[j] = temp+pre;
					pre = temp;
				}
			}
		}
		for(int k = 0;k<rowIndex+1;k++)
			result.add(res[k]);
		return result;
	}
}
