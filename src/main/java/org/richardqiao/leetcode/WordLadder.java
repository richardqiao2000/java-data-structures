package org.richardqiao.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		List<String> ladder = ladder("hiat", "cog", set);
		for(String wd: ladder) System.out.print(wd + " -> ");
	}
	static class Node{
		public String word;
		public Node next;
		public Node(String wd){
			word = wd;
			next = null;
		}
		@Override
		public int hashCode(){
			return word.hashCode();
		}
		@Override
		public boolean equals(Object o){
			Node nd = (Node)o;
			return this.word.equals(nd.word);
		}
	}
	private static List<String> ladder(String start, String end, Set<String> dict){
		LinkedList<String> res = new LinkedList<String>();
		Set<Node> set1 = new HashSet<Node>();
		Set<Node> set2 = new HashSet<Node>();
		set1.add(new Node(start)); set2.add(new Node(end));
		dict.remove(start); dict.remove(end);
		Node nodeMid = null;
		boolean bSeq = true;
		while(!set1.isEmpty() && !set2.isEmpty()){
			Set<Node> nextWords = new HashSet<Node>();
			if(set1.size() > set2.size()){
				Set<Node> tmp = set1;
				set1 = set2;
				set2 = tmp;
				bSeq = !bSeq;
			}
			boolean notFound = true;
			for(Node nd: set1){
				nodeMid = getNextNodes(nd, nextWords, set2, dict);
				if(nodeMid != null){
					notFound = false;
					break;
				}
			}
			if(!notFound) break;
			set1 = nextWords;
		}
		if(nodeMid == null){
			return res;
		}
		Node nodeMid2 = new Node("");
		for(Node nd: set2){
			if(nd.word.equals(nodeMid.word)){
				nodeMid2 = nd;
				break;
			}
		}
		if(bSeq){
			Node tmp = nodeMid;
			nodeMid = nodeMid2;
			nodeMid2 = tmp;
		}
		while(nodeMid != null){
			res.addLast(nodeMid.word);
			nodeMid = nodeMid.next;
		}
		nodeMid2 = nodeMid2.next;
		while(nodeMid2 != null){
			res.addFirst(nodeMid2.word);
			nodeMid2 = nodeMid2.next;
		}
		return res;
	}
	
	private static Node getNextNodes(Node node, Set<Node> nextWords, Set<Node> set2, Set<String> dict){
		StringBuilder sb = new StringBuilder(node.word);
		for(int i = 0; i < sb.length(); i++){
			char ch = sb.charAt(i);
			for(char tmp = 'a'; tmp <= 'z'; tmp++){
				if(tmp == ch) continue;
				sb.setCharAt(i, tmp);
				String tstr = sb.toString();
				Node newNode = new Node(tstr);
				if(set2.contains(newNode)){
					newNode.next = node;
					return newNode;
				}
				else if(!nextWords.contains(tstr) && dict.contains(tstr)){
					dict.remove(tstr);
					newNode.next = node;
					nextWords.add(newNode);
				}
			}
			sb.setCharAt(i, ch);
		}
		return null;
	}
}
