package algorithm.sorting;

/**        
 * Title: heapSort.java    
 * Description: 
 * @author caigen       
 * @created 2015年5月15日 下午8:52:22    
 */

public class HeapSort implements ISort 
{

	/** 
	 * Description:堆排序算法，调整成堆O(logn	),总时间复杂度O(nlogn)
	 * @author caigen       
	 * @created 2015年5月15日 下午8:52:22      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	//堆是完全二叉树
	//把n个元素的数组看成堆的层遍历，第i个元素有一下性质：
	//i=0，则i为根节点；
	//若2i+1<n，则2i+1为它的左孩子，若2i+2<n，则为i的右孩子
	//它的父节点为(i-1)/2
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		//先把数组排成最大堆：从最后一个元素n-1的父节点（深度最深的子树）开始，从后往前遍历所有的非零度节点排成最大堆
		int n=a.length;
		for(int i=(n-1-1)/2;i>=0;i--)
			sift(a,i,n-1);
		//每次去除第一个最大的元素放在末尾，然后把剩下的元素再排成最大堆
		for(int j=n-1;j>0;j--){
			int temp=a[0];
			a[0]=a[j];
			a[j]=temp;
			sift(a, 0, j-1);
		}
	}

	/**     
	 * Description: 将根节点为begin的子数组排成最大堆，根节点为要插入的元素
	 * @param a 要排序的数组
	 * @param begin 堆中要插入的元素，为子树的根节点
	 * @param end   堆的最后一个元素
	 */
	private void sift(int[] a, int begin, int end){
		int i=begin,j=2*i+1;
		int temp=a[i];
		while(j<=end){
			//比较左右结点大小，保证平衡性
			if(j<end&&a[j]<a[j+1]){
				j++;
			}
			if(temp<a[j]){
				a[i]=a[j];
				//待插入元素到达位置j
				i=j;
				j=2*j+1;
			}
			else break;
		}
		a[i]=temp;
	}
	
}
