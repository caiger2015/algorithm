package algorithm.sorting;
/*
 *计数排序算法，时间复杂度O(n)，空间复杂度O(n)
 *算法思路：在知道所要排序的数组中元素的大致范围时使用，该范围关系到桶数组b的大小：可以是max-min+1，也可以和a数组相同的大小
 *		        1.数组中元素一共有k个不同的值，那么利用一个桶数组来存储这些不同元素的个数。对数组a：{2,4,1,3,2,3,6}，
 *			 一共有6-1+1=6个可能不同的值（max-min+1），那么申请一个大小为6的数组b。遍历a统计a中元素个数记录在b中
 *			 得到b：{0,1,2,2,1,0,1}。
 *				2.方案一，将b中元素转换为b[a[j]]表示a中<=a[j]的元素的个数：{0,1,3,5,6,0,7}，此时b[a[j]]-1表示a[j]的位置；
 *			 构造返回数组c，将a[j]按照b[a[j]]-1放入c中，同时更新b[a[j]],每放一个b[a[j]]--。
 *				3.方案二，由于b的索引代表a中元素，那么可以不用数组c，利用索引直接构造a；按照b[j]的大小从a[0]开始构造
 *			 
 */

public class CountingSort implements ISort {

	@Override
	public void sort(int[] a) {
		int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
		//找到最大和最小
		for(int i:a){
			if(i > max){
				max = i; 
			} 
			if(i < min){
				min = i;
			}
		}
		int[] b = new int[max-min+1];
		//统计a[j]个数对应到b中，i-min可以处理有负数的情况
		for(int i : a){
			b[i-min]++;
		}
		int t = 0;
		for(int j = min; j < b.length+min; j++){
			while(b[j-min] > 0){
			    a[t++] = j;
			    b[j-min]--;
			}
		}
		
//		//b[j]表示a中<=j的元素的个数
//		for(int j = 1; j < b.length; j++){
//			b[j] = b[j] + b[j-1];
//		}
//		//
//		int c[] = new int[a.length];
//		for(int k = 0;k < a.length; k++){
//			c[b[a[k]]-1] = b[a[k]];
//			b[a[k]]--;
//		}
//		return c;
		
	}
	
}
