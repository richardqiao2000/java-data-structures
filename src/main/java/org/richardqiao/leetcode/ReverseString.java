package org.richardqiao.leetcode;

public class ReverseString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringBuilder("asdfj32j42XCV").reverse().toString());
		String str = "asdjf;lajsdoprup0234rqwefasdfavj;pjksdk[wqpierurqwyeupo";
		str = "aaaASDFEWRTYWERTQWVXCVBNM<IORYTUYgeqwe2	e145twgsdacxvxcvbed	qfascfdf;ajf[p0ier9pi";
		char[] chars = str.toCharArray();
		int i = 0, j = 0;
		while(j < chars.length){
			if(!isOwal(chars[j])){
				chars[i++] = chars[j];
			}
			j++;
		}
		while(i < chars.length){
			chars[i++] = '\0';
		}
		System.out.println(String.valueOf(chars));
	}
	
	private static boolean isOwal(char ch){
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
		   ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
		) return true;
		return false;
	}

}
