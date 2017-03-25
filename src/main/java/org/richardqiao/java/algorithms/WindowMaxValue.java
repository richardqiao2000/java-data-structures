package org.richardqiao.java.algorithms;

import java.util.*;

public class WindowMaxValue {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for(int num: windowMax(new int[]{234,2,312,3,4,23,12,12,21,87,23,212,1232}, 5)){
      System.out.print(num + ", ");
    }
  }

  private static int[] windowMax(int[] nums, int k){
    int[] res = new int[nums.length - k + 1];
    LinkedList<Integer> window = new LinkedList<Integer>();
    for(int i = 0; i < nums.length; i++){
      while(!window.isEmpty() && window.getLast() < i - k + 1){
        window.removeLast();
      }
      while(!window.isEmpty() && nums[window.getFirst()] <= nums[i]){
        window.removeFirst();
      }
      window.addFirst(i);
      if(i >= k - 1){
        res[i - k + 1] = nums[window.getLast()];
      }
    }
    return res;
  }
}
