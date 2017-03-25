package org.richardqiao.java.algorithms;

public class RotateImage {
  public static void main(String[] args){
    int[][] origin = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    for(int i = 0; i < origin.length; i++){
      for(int j = 0; j < origin[0].length; j++){
        System.out.print(origin[i][j] + ", ");
      }
      System.out.println();
    }
    System.out.println();
    int[][] res = rotate(origin);
    for(int i = 0; i < res.length; i++){
      for(int j = 0; j < res[0].length; j++){
        System.out.print(res[i][j] + ", ");
      }
      System.out.println();
    }
  }
  
  private static int[][] rotate(int[][] image){
    for(int i = 0, j = image.length - 1; i < j; i++, j--){
      for(int k = 0; k < image[0].length; k++){
        int tmp = image[i][k];
        image[i][k] = image[j][k];
        image[j][k] = tmp;
      }
    }
    for(int i = 0; i < image.length; i++){
      for(int j = 0; j < i; j++){
        int tmp = image[i][j];
        image[i][j] = image[j][i];
        image[j][i] = tmp;
      }
    }
    return image;
  }
}
