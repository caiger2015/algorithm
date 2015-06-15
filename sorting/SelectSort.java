package algorithm.sorting;

/**        
 * Title: SelectSort.java    
 * Description: 
 * @author caigen       
 * @created 2015年5月14日 下午9:39:54    
 */

public class SelectSort implements ISort {

	/** 
	 * Description:直接选择排序，复杂度O(n^2),不稳定
	 * @author caigen       
	 * @created 2015年5月14日 下午9:39:54      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		//循环n-1次
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;
			//找出最小值的索引
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j])
					min=j;
			}
			//交换到排序的位置
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
	}

}
