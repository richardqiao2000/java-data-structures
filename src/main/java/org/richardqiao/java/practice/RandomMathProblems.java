package org.richardqiao.java.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class RandomMathProblems {

  private final int DIGITS;
  public RandomMathProblems(){
    DIGITS = 3;
  }
   
  public static void main(String[] args) throws IOException {
    RandomMathProblems app = new RandomMathProblems();
    File file = new File("E:/Workspaces/Algorithm/java-datastructures/target/test.txt");
    FileOutputStream fos = new FileOutputStream(file);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    for(int i = 0; i < 8; i++){
      String tmp = "";
      if(new Random().nextInt(2) > 0){
        tmp = app.getOneAddition();
      }else{
        tmp = app.getOneSubtraction();
      }
      
      bw.write(tmp);
      bw.newLine();
    }
    bw.close();
  }
  public String getOneAddition(){
    int num1 = getRandomIn((int)Math.pow(10, DIGITS));
    int num2 = getRandomIn((int)Math.pow(10, DIGITS));
    int digits = 0;
    int tmp = num1;
    StringBuilder sb = new StringBuilder();
    while(tmp > 0){
      digits++;
      tmp /= 10;
    }
    digits = DIGITS + 3 - digits;
    while(digits-- > 0){
      sb.append(" ");
    }
    sb.append(num1 + "\n");
    tmp = num2;
    digits = 0;
    sb.append(" + ");
    while(tmp > 0){
      digits++;
      tmp /= 10;
    }
    digits = DIGITS - digits;
    while(digits-- > 0){
      sb.append(" ");
    }
    sb.append(num2 + "\n");
    digits = DIGITS + 4;
    while(digits-- > 0){
      sb.append("-");
    }
    sb.append("\n");
    sb.append(" = \n");
    return sb.toString();
  }
  
  public String getOneSubtraction(){
    int num1 = getRandomIn((int)Math.pow(10, DIGITS));
    int num2 = getRandomIn(num1);
    int digits = 0;
    int tmp = num1;
    StringBuilder sb = new StringBuilder();
    while(tmp > 0){
      digits++;
      tmp /= 10;
    }
    digits = DIGITS + 3 - digits;
    while(digits-- > 0){
      sb.append(" ");
    }
    sb.append(num1 + "\n");
    tmp = num2;
    digits = 0;
    sb.append(" - ");
    while(tmp > 0){
      digits++;
      tmp /= 10;
    }
    digits = DIGITS - digits;
    while(digits-- > 0){
      sb.append(" ");
    }
    sb.append(num2 + "\n");
    digits = DIGITS + 4;
    while(digits-- > 0){
      sb.append("-");
    }
    sb.append("\n");
    sb.append(" = \n");
    return sb.toString();
  }
  
  private int getRandomIn(int max){
    return new Random().nextInt(max) + 1;
  }
}
