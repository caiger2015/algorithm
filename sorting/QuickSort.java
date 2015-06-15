package algorithm.sorting;

public class QuickSort implements ISort {
	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	/** 
	 * Description:快速排序算法，时间复杂度O(nlogn)
	 * @author caigen       
	 * @created 2015年5月14日 下午8:39:52      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */  
	    
	@Override
	public void sort(int[] a) {
		// TODO Auto-generated method stub
		if(a==null||a.length<=1)
			return;
		int begin=0,end=a.length-1;
		quickSort(a, begin, end);
	}
	/**     
	 * Description: 
	 * @param a 要排序的数组
	 * @param begin
	 * @param end     
	 */
	private void quickSort(int[] A,int begin, int end){
		if(begin>=end)
			return;
		int index=partition(A,begin,end);
		//递归调用，每次进行partition时的begin和end都在更新
		quickSort(A,begin,index-1);
		quickSort(A,index+1,end);
	}
/**     
	 * Description: 找到索引为begin的元素在数组A中排序好后的位置
	 * @param A	目标数组
	 * @param begin	开始的下标
	 * @param end	结束的下标
	 * @return  返回begin对应的数组元素排序后的位置
	 */
	private int partition(int[] a, int begin, int end) {
		int temp=a[begin];
		//双指针逐步确定temp的最终位置
		while(begin<end){
			while(begin<end&&temp<a[end])//取<是逆序
				end--;
			a[begin]=a[end];
			while(begin<end&&temp>=a[begin])//<=是逆序
				begin++;
			a[end]=a[begin];
		}
		a[begin]=temp;
		return begin;
	}
	@SuppressWarnings("unused")
	private  void quickSort1(int[] A, int begin, int end) {
		if(begin>=end)
			return;
		//存储传进来的参数
		int i=begin,j=end,temp=A[i];
		while(i<j){
			while(temp<=A[j]&&i<j){
				j--;
			}
			//当跳出一个多条件循环时，要判断是哪一个条件
			//if(i<j){
				//swap(A,i,j);
				A[i]=A[j];
				//i++;
			//}
			while(temp>=A[i]&&i<j){
				i++;
			}
			//if(i<j){
				//swap(A,i,j);
				A[j]=A[i];
				//j--;
			//}
		}
		A[i]=temp;
		quickSort1(A,begin,i-1);
		quickSort1(A,i+1,end);
		return;
	}
	@SuppressWarnings("unused")
	private static void swap(int[] A,int a,int b){
		A[a]=A[a]^A[b];
		A[b]=A[a]^A[b];
		A[a]=A[a]^A[b];
	}
}
