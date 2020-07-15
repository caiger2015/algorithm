package com.cg.leetcode.dynamicProgramming;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(maximalSquare(new char[][]{{'1','1'},{'1','1'}}));
	}
	//动态规划问题想递推公式求解，逐步构造结果矩阵，利用之前得到的矩阵元素递推后边的元素。
	public static int maximalSquare(char[][] matrix) {
		 if(matrix == null||matrix.length == 0||matrix[0].length == 0)
			 return 0;
		 int n = matrix.length;
		 int m = matrix[0].length;
		 //结果矩阵，其中的（i，j）元素表示以它为最右下角的正方形的边长
		 int[][] size = new int[n][m];
		 int max = 0;
		 for(int i = 0;i<n;i++){
			 //matrix中的元素是char，会隐式转换成asc码数值和数值类型比较编译也可以通过
			 if(matrix[i][0] == '1')
				 max = 1;
				 size[i][0] = matrix[i][0]-'0';
		 }
		 for(int j = 0;j<m;j++){
			 if(matrix[0][j] == '1')
				 max = 1;
			 size[0][j] = matrix[0][j]-'0';
		 }
		 for(int i = 1;i<n;i++){
			 for(int j = 1;j<m;j++){
				 if(matrix[i][j] == '0')
					 size[i][j] = 0;
				 else{
					 //递推关系：f(i,j) = min(f(i-1,j),f(i,j-1),f(i-1,j-1))+1
					 size[i][j] = Math.min(Math.min(size[i-1][j],size[i][j-1]),size[i-1][j-1])+1;
					 max = Math.max(max, size[i][j]);
				 }
			 }
		 }
		 return max*max;
	}
//	public static int maximalSquare2(char[][] matrix) {
//		 if(matrix == null||matrix.length == 0)
//			 return 0;
//		 int row = matrix.length;
//		 int col = matrix[0].length;
//		 int[] side = new int[col];
//		 int maxSide = 0;
//		 for(int k = 0;k<col;k++)
//			 side[k] = 0;
//		 for(int i = 0;i<row;i++){
//			 for(int j = col-1;j>0;j--){
//				 if(matrix[i][j] == '0'){
//					 side[j] = 0;
//					 continue;
//				 }
//				 if(isSquare(matrix,side[j-1],i,j)){
//					 side[j] = side[j-1]+1;
//				 }
//				 else{
//					 side[j] = 1;
//				 }
//			 }
//			 side[0] = matrix[i][0]-'0';
//			 for(int k = 0;k<col;k++){
//				 if(maxSide<= side[k])
//					 maxSide = side[k];
//			 }
//		 }
//		 return maxSide*maxSide;
//	 }
//	private static boolean isSquare(char[][] matrix, int diff, int i, int j) {
//		for(int k = diff;k>0;k--){
//			if(matrix[i][j-k] == '0')
//				return false;
//			if(matrix[i-k][j] == '0')
//				return false;
//		}
//		return true;
//	}

}
