package org.richardqiao.leetcode;

public class MatrixMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = multiply(new int[][]{{1,2,3}, {4,5,6}}, new int[][]{{2,3}, {4,5}, {6,7}});
		for(int[] arr: res){
			for(int n: arr){
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
  private static int[][] multiply(int[][] A, int[][] B){
    int[][] res = new int[A.length][B[0].length];
    if(A.length == 0 || A[0].length == 0) return res;
    if(B.length == 0 || B[0].length == 0) return res;
    for(int i = 0; i < A.length; i++){
      for(int j = 0; j < B[0].length; j++){
        for(int k = 0; k < B.length; k++){
        	res[i][j]+= A[i][k] * B[k][j];
        }
      }
    }
    return res;
  }
}
