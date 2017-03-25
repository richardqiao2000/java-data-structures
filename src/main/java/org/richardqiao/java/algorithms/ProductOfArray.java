package org.richardqiao.java.algorithms;

public class ProductOfArray {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for(int num: productOfArray(new int[]{3,2,1,2,3,4,2,12})){
      System.out.print(num + ", ");
    }
  }

  private static int[] productOfArray(int[] nums){
    int[] res = new int[nums.length];
    if(res.length == 0) return res;
    res[0] = 1;
    for(int prod = 1, i = 1; i < nums.length; i++){
      prod *= nums[i - 1];
      res[i] = prod;
    }
    for(int prod = 1, i = nums.length -2; i >= 0; i--){
      prod *= nums[i + 1];
      res[i] *= prod;
    }
    return res;
  }
  
}
