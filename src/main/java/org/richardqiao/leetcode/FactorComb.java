package org.richardqiao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FactorComb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> facs = factorComb(2121212133);
		for(List<Integer> list: facs){
			for(int num: list){
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}
	private static List<List<Integer>> factorComb(int n){
		List<List<Integer>> res = new ArrayList();
		if(n < 4){
			return res;
		}
		dfs(res,new ArrayList<Integer>(), n);
		res.remove(res.size() - 1);
		return res;
	}
	
	private static void dfs(List<List<Integer>> res, List<Integer> list, int num){
		if(num == 1){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = list.size() == 0 ? 2 : list.get(list.size() - 1); i <= Math.sqrt(num); i++){
			if(num % i == 0){
				list.add(i);
				dfs(res, list, num / i);
				list.remove(list.size() - 1);
			}
		}
		list.add(num);
		dfs(res, list, 1);
		list.remove(list.size() - 1);
	}
}
