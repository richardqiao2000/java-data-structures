package org.richardqiao.leetcode;

public class TernaryExpressionParser {

	static class TreeNode{
		String val;
		TreeNode left, right;
		public TreeNode(String s){
			val = s;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = parse("a?a?b?c:d:e?a?b?c:d:e:a?b?c:d:e:a?b?c:d:e");
		System.out.println(traverse(root));
	}
	
	private static String traverse(TreeNode root){
		if(root.left == null && root.right == null){
			return root.val;
		}
		return root.val + "{" + traverse(root.left) + "," + traverse(root.right) + "}";
	}

	//a ? b : c
	//a ? b ? c : d : e
	//a ? b : c ? d : e
	static int cur = 0;
	private static TreeNode parse(String exp){
		StringBuilder sb = new StringBuilder();
		while(cur < exp.length() && exp.charAt(cur) != '?' && exp.charAt(cur) != ':'){
			sb.append(exp.charAt(cur));
			cur++;
		}
		TreeNode node = new TreeNode(sb.toString().trim());
		if(cur < exp.length() && exp.charAt(cur) == '?'){
			cur++;
			node.left = parse(exp);
			cur++;//":"
			node.right = parse(exp);
		}
		return node;
	}
}
