package org.richardqiao.java.practice;

public class GCD {
	public static int gcd(int x, int y){
		if(x == 0 || y == 0) return 1;
		long a = x, b = y;
		a = Math.abs(a);
		b = Math.abs(b);
		while(b > 0){
			long tmp = b;
			b = a % b;
			a = tmp;
		}
		return (int)a;
	}
}
