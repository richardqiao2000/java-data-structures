package org.richardqiao.java.algorithms;

import java.util.Stack;

/*
 * Given an encoded string, return it's decoded string.

  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

  You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
  
  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
  
  Examples:
  
  s = "3[a]2[bc]", return "aaabcbc".
  s = "3[a2[c]]", return "accaccacc".
  s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * */


public class DecodeString {
  public String decode(String s){
    StringBuilder res = new StringBuilder();
    int cur = 0;
    Stack<Integer> stackI = new Stack();
    Stack<String> stackS = new Stack();
    for(int i = 0; i < s.length(); i++){
      char ch = s.charAt(i);
      if(Character.isLetter(ch)){
        res.append(ch);
      }else if(Character.isDigit(ch)){
        cur = ch - '0';
        while(Character.isDigit(s.charAt(i + 1))){
          cur *= 10;
          cur += s.charAt(++i) - '0';
        }
        stackI.push(cur);
      }else if(ch == '['){
        stackS.push(res.toString());
        res.setLength(0);
      }else{
        String tmp = res.toString();
        res = new StringBuilder(stackS.pop());
        int count = stackI.pop();
        while(count-- > 0){
          res.append(tmp);
        }
      }
    }
    return res.toString();
  }
}
