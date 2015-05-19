package algorithm.sorting;


/**        
 * Title: MergeSort.java    
 * Description: 
 * @author caigen       
 * @created 2015年5月14日 下午10:35:17    
 */

public class MergeSort implements ISort {

	/** 
	 * Description:归并排序算法，复杂度O(nlogn)~O(n^2),稳定的
	 * @author caigen       
	 * @created 2015年5月14日 下午10:35:17      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		int begin=0,end=a.length-1;
		int[] b=new int[a.length];
		mergeSort(a,b,begin,end);
	}
	/**     
	 * Description: 递归调用进行分组	
	 * @param a  要排序的数组	
	 * @param b	 辅助数组
	 * @param begin  子数组开始
	 * @param end    子数组结尾 
	 */
	private void mergeSort(int[] a, int[] b,int begin, int end) {
		if(begin>=end)
			return;
		int mid=(begin+end)/2;
		mergeSort(a,b,begin,mid);
		mergeSort(a,b,mid+1,end);
		merge(a,b,begin,mid,end);
	}
	/**     
	 * Description: 利用辅助数组合并两个子数组
	 * @param a  要排序的数组	
	 * @param b	 辅助数组
	 * @param begin  第一个子数组开始
	 * @param mid	第一个子数组结尾
	 * @param end    第二个子数组结尾
	 */
	private void merge(int[] a, int[] b,int begin, int mid, int end) {
		if(begin>=end)
			return;
		int i=begin,j=mid+1,k=begin;
		while(i<=mid&&j<=end){
			if(a[i]<=a[j]){
				b[k++]=a[i++];
			}
			else if(a[i]>a[j]){
				b[k++]=a[j++];
			}
		}
		while(i<=mid)
			b[k++]=a[i++];
		while(j<=end)
			b[k++]=a[j++];
		for(int m=begin;m<=end;m++){
			a[m]=b[m];
		}
	}

}
