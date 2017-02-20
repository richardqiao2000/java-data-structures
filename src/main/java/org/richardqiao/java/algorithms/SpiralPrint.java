package org.richardqiao.java.algorithms;

public class SpiralPrint {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] matrix = new int[][]{{1,2,3,4,5},
                                 {6,7,8,9,10},
                                 {1,2,3,4,5},
                                 {6,7,8,9,10},
                                 {1,2,3,4,5}};
    int[] res = spiralPrint(matrix);
    for(int num: res) System.out.print(num + ", ");
  }
  public static int[] spiralPrint(int[][] matrix){
    int m = matrix.length;
    if(m == 0) return new int[0];
    int n = matrix[0].length;
    if(n == 0) return new int[0];
    if(m != n || m % 2 == 0) return new int[0];
    int[] res = new int[m * n];
    int i = m / 2, j = n / 2;
    int width = 1;
    int k = 0;
    while(j < n){
      if(width == 1){
        res[k++] = matrix[i][j++];
      }else{
        //move down (width - 1)
        for(int step = 0; step < width - 1; step++){
          res[k++] = matrix[i++][j];
        }
        i--;
        j--;
        for(int step = 0; step < width - 1; step++){
          res[k++] = matrix[i][j--];
        }
        j++;
        i--;
        for(int step = 0; step < width - 1; step++){
          res[k++] = matrix[i--][j];
        }
        i++;
        j++;
        for(int step = 0; step < width - 1; step++){
          res[k++] = matrix[i][j++];
        }
        j--;
      }
      j++;
      width += 2;
    }
    return res;
  }
}
