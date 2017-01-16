package org.richardqiao.leetcode;

public class FindCelebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(celebrity(30));
	}
	
	private static int celebrity(int n){
		if(n < 2) return -1;
		int i = 0, j = n - 1;
		int lastJ = j;
		while(i < j){
			if(knows(i, j)){
				i++;
				lastJ = j;
			}
			else if(knows(j, i)) j--;
			else{
				lastJ = j;
				i++;
				j--;
			}
		}
		for(int k = 0; k < i; k++){
			if(!knows(k, i) || knows(i, k)) return -1;
		}
		for(int k = lastJ + 1; k < n; k++){
			if(!knows(k, i) || knows(i, k)) return -1;
		}
		return i + 1;
	}
	
	private static boolean knows(int a, int b){
		return true;
	}
}
