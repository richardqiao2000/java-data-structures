package org.richardqiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PalindromeEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minEdit("aaccadfasdfweruweiurfdaccaaweruwei", new HashMap<String, Integer>()));
	}

	static int minEdit(String str, Map<String, Integer> map){
		if(str.length() < 2){
			return 0;
		}
		if(map.containsKey(str)){
			return map.get(str);
		}
		int i = 0, j = str.length() - 1;
		while(i < j && str.charAt(i) == str.charAt(j)){
			i++;
			j--;
		}
		if(i >= j){
			map.put(str, 0);
			return 0;
		}
		int a = 1 + minEdit(str.substring(i + 1, j + 1), map);
		int b = 1 + minEdit(str.substring(i, j), map);
		int c = 1 + minEdit(str.substring(i + 1, j), map);
		a = Math.min(a, Math.min(b, c));
		map.put(str, a);
		return a;
	}
}
