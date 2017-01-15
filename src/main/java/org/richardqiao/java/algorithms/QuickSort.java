package org.richardqiao.java.algorithms;

import java.util.Random;

public class QuickSort {
  public int[] quickSort(int[] nums){
    Random rnd = new Random();
    for(int i = nums.length - 1; i >= 0; i--){
      int j = rnd.nextInt(i + 1);
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    sort(nums, 0, nums.length);
    return nums;
  }
  
  private void sort(int[] nums, int start, int end){
    if(start >= end - 1) return;
    int j = start;
    for(int i = start; i < end; i++){
      if(nums[i] < nums[j]){
        int tmp = nums[j + 1];
        nums[j + 1] = nums[i];
        nums[i] = tmp;
        tmp = nums[j];
        nums[j] = nums[j + 1];
        nums[j + 1] = tmp;
        j++;
      }
    }
    sort(nums, start, j);
    sort(nums, j + 1, end);
  }
  
  public static void main(String[] args){
    QuickSort qs = new QuickSort();
    for(int num: qs.quickSort(new int[]{3,2,1,5,6,4})){
      System.out.print(num + ", ");
    }
  }
}
