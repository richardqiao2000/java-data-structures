package org.richardqiao.java.algorithms;

public class FirstUniqueChar {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(firstUnique("haha"));
  }

  private static char firstUnique(String str){
    int[] counter = new int[128];
    char[] chs = str.toCharArray();
    for(char ch: chs){
      counter[ch]++;
    }
    for(char ch: chs){
      if(counter[ch] == 1){
        return ch;
      }
    }
    return '\0';
  }
}
