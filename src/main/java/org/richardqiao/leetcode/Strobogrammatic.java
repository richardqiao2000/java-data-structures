package org.richardqiao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		for(String str: findAll("100000000000000".length())){
			System.out.println(count++ + ": " + str);
		}
		System.out.println(count("100000000000000".length()));
		//69999996666669
		//1 6 8
		//83234 - 86068
		//86899 - 89069 - 89168 89868 90006 91016  
	}
	
	private static List<String> findAll(int n){
		List<String> list = new ArrayList<String>();
		if(n == 1){
			list.add("0");list.add("1");list.add("8");
		}else{
			int d = n / 2;
			if(n % 2 == 1) d++;
			dfs(list, d, "", n % 2 == 0);
		}
		return list;
	}
	
	private static void dfs(List<String> list, int n, String str, boolean flag){
		if(n == 0){
			StringBuilder sb = new StringBuilder(str);
			if(!flag){
				sb.setLength(str.length() - 1);
			}
			for(int i = 0; i < sb.length(); i++){
				if(sb.charAt(i) == '6') sb.setCharAt(i, '9');
				else if(sb.charAt(i) == '9') sb.setCharAt(i, '6');
			}
			sb.reverse();
			list.add(str + sb.toString());
			return;
		}
		if(str.length() > 0){
			dfs(list, n - 1, str + "0", flag);
		}
		dfs(list, n - 1, str + "1", flag);
		if(str.length() == 0 || flag || !flag && n != 1){
			dfs(list, n - 1, str + "6", flag);
		}
		dfs(list, n - 1, str + "8", flag);
		if(str.length() == 0 || flag || !flag && n != 1){
			dfs(list, n - 1, str + "9", flag);
		}
	}
	
	private static int count(int n){
		if(n == 1) return 3;
		int half = n / 2 - 1;
		int mod = n % 2;
		int count = 4;//1, 6, 8, 9
		while(half-- > 0){
			count *= 5;
		}
		if(mod == 1) count *= 3;
		return count;
	}

	private static int findIndex(String str, int n){
		//78998820100182
		//
		return 0;
	}
	
	private static int count(String start, String end){
		return 0;
	}
	
}
