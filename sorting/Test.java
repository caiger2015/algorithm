package algorithm.sorting;

import java.util.Arrays;
/**        
 * Title: Test.java    
 * Description: 
 * @author caigen       
 * @created 2015年5月14日 下午8:33:52    
 */

public class Test {

	/**     
	 * Description: 
	 * @param args     
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[]{2,1,3,9,6,2,4,1,9,7};
		ISort sortMethod= new QuickSort();
		sortMethod.sort(a);
		System.out.println(Arrays.toString(a)+sortMethod.toString());
	}
}
