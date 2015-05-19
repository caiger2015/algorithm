package algorithm.searching;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{1,2,3,4,5,6,7,8};
		int x=binarySearchWithLoop(A,7);
		System.out.print(x+"");
	}
	public static int binarySearch(int[] A,int begin,int end,int target){
		if(begin>end)
			return -1;
		int mid=(begin+end)/2;
		if(A[mid]>target)
			return binarySearch(A,begin,mid-1,target);
		else if(A[mid]<target)
			return binarySearch(A,mid+1,end,target);
		else
			return mid;		
	}
	public static int binarySearch(int[] A,int target){
		if(A==null||A.length==0)
			return -1;
		int begin=0;
		int end=A.length-1;
		return binarySearch(A,begin,end,target);
	}
	public static int binarySearchWithLoop(int[] A ,int target){
		if(A==null||A.length==0)
			return -1;
		int begin=0;
		int end=A.length-1;
		while(begin<=end){
			int mid=(begin+end)/2;
			if(A[mid]>target)
				end=mid-1;
			else if(A[mid]<target)
				begin=mid+1;
			else
				return mid;
		}
		return -1;
	}
}
