package org.richardqiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Itinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String str: reconstruct(new String[][]{{"JFK", "AAA"}, {"JFK", "DDD"}, {"AAA", "CCC"}, {"BBB", "CCC"},
												   {"CCC", "JFK"}, {"CCC", "DDD"}, {"DDD", "AAA"}, {"DDD", "BBB"}})){
			System.out.print(str + " -> ");
		}
	}

	static List<String> reconstruct(String[][] tickets){
		Arrays.sort(tickets, new Comparator<String[]>(){
			@Override
			public int compare(String[] a, String[] b){
				if(a[0].equals(b[0])){
					return a[1].compareTo(b[1]);
				}
				return a[0].compareTo(b[0]);
			}
		});
		Map<String, LinkedList<String>> map = new HashMap();
		for(String[] tic: tickets){
			if(!map.containsKey(tic[0])){
				map.put(tic[0], new LinkedList<String>());
			}
			map.get(tic[0]).add(tic[1]);
		}
		String cur = "JFK";
		List<String> res = new LinkedList();
		Stack<String> stack = new Stack<String>();
		stack.push(cur);
		while(!stack.isEmpty()){
			cur = stack.peek();
			while(map.containsKey(cur) && !map.get(cur).isEmpty()){
				cur = map.get(cur).pollFirst();
				stack.push(cur);
			}
			res.add(0, stack.pop());
		}
		return res;
	}
}
