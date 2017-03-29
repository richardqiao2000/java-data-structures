package org.richardqiao.java.algorithms;

public class ConvertIPV6 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    long num = 9199999121213213121l;
    String str = ipV6(num);
    System.out.println(num + " -> " + str);
    System.out.println(str + " -> " + ipNum(str));
    System.out.println(ipNum("7FFF:FFFF:FFFF:FFFF"));
  }
  
  //2001:0DBB:AC10:FE01
  private static String ipV6(long num){
    char[] digits = "0123456789ABCDEF".toCharArray();
    char[] chs = new char[16];
    int count = 15;
    while(count >= 0){
      int mod = (int) (num % 16);
      num /= 16;
      chs[count--] = digits[mod];
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < chs.length; i++){
      sb.append(chs[i]);
      if((i + 1) % 4 == 0 && i != chs.length - 1){
        sb.append(":");
      }
    }
    return String.valueOf(sb.toString());
  }
  
  private static long ipNum(String ipV6){
     ipV6 = ipV6.replace(":", "");
     long sum = 0;
     
     for(char ch: ipV6.toCharArray()){
       int num = 0;
       if(Character.isDigit(ch)){
         num = ch - '0';
       }else{
         num = 10 + ch - 'A';
       }
       sum = sum * 16 + num;
     }
    return sum;
  }

}
