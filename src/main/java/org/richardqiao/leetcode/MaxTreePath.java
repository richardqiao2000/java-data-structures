package org.richardqiao.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxTreePath {

	static class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	static int max = Integer.MIN_VALUE;
	static List<Integer> maxList = new LinkedList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(88);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(1000);
		root.right.left.right = new TreeNode(-10001);
		root.right.left.left = new TreeNode(-20001);
		
		maxPath(root);
		for(int num: maxList){
			System.out.print(num + " -> ");
		}
	}
	//1{2{3{N,4}},N}
	static TreeNode build(String str){
		return null;
	}
	static List<Integer> maxPath(TreeNode root){
		if(root == null) return null;
		List<Integer> lList = maxPath(root.left);
		List<Integer> rList = maxPath(root.right);
		List<Integer> res = new LinkedList<Integer>();
		List<Integer> maxSubList = new LinkedList<Integer>();
		int maxSub = root.val;
		if(lList != null && root.left.val > 0){
			maxSub += root.left.val;
			List<Integer> llList = new LinkedList<Integer>(lList);
			Collections.reverse(llList);
			maxSubList.addAll(llList);
		}
		maxSubList.add(root.val);
		if(rList != null && root.right.val > 0){
			maxSub += root.right.val;
			maxSubList.addAll(rList);
		}
		if(max < maxSub){
			maxList = maxSubList;
		}
		int lValue = lList == null ? Integer.MIN_VALUE : root.left.val;
		int rValue = rList == null ? Integer.MIN_VALUE : root.right.val;
		res.add(root.val);
		if(lValue > rValue && lValue > 0){
			res.addAll(lList);
		}else if(rValue > lValue && rValue > 0){
			res.addAll(rList);
		}
		return res;
	}
	
}
