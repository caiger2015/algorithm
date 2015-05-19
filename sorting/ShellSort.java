package algorithm.sorting;

/**        
 * Title: ShellSort.java    
 * Description: 
 * @author caigen       
 * @created 2015年5月14日 下午8:14:54    
 */
 
public class ShellSort implements ISort{
	/** 
	 * Description:
	 * @author caigen       
	 * @created 2015年5月14日 下午8:56:28      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */ 
	@Override
	public void sort(int[] a){
		if(a==null||a.length<=1)
			return;
		int n=a.length;
		for(int d=n/2;d>0;d/=2)
		{
			for(int i=d;i<n;i++)
			{
				int temp=a[i],j;
				for(j=i-d;j>0&&temp<a[j];j-=d)
					a[j+d]=a[j];
				a[j+d]=temp;
			}
		}
	}
}
