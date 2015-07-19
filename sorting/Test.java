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
		int[] a=new int[]{5,2,5,1,6,3,5,4,5,-1,-1,-2};
		ISort sortMethod= new CountingSort();
		sortMethod.sort(a);
		System.out.println(Arrays.toString(a)+sortMethod.toString());
	}
}
