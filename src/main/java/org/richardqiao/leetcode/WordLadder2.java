package org.richardqiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("manic");
		set.add("mania");
		set.add("maria");
		set.add("maris");
		set.add("marks");

		set.add("parks");
		set.add("perks");
		set.add("peaks");
		set.add("pears");
		set.add("parry");
		set.add("perry");
		set.add("merry");
		set.add("party");
		set.add("paris");

		set.add("marty");
		set.add("marta");
		set.add("marry");
		set.add("peary");
		
		List<List<String>> ladders = findLadders("magic", "pearl", set);
		for(List<String> list: ladders){
			for(String wd: list){
				System.out.print(wd + " -> ");
			}
			System.out.println();
		}
	}

	static class Node{
		public String word;
		public List<Node> nexts;
		public Node(String wd){
			word = wd;
			nexts = new ArrayList<Node>();
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
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList();
		Set<Node> set1 = new HashSet<Node>();
		Set<Node> set2 = new HashSet<Node>();
		set1.add(new Node(beginWord)); set2.add(new Node(endWord));
		wordList.remove(beginWord); wordList.remove(endWord);
		Node nodeMid = null;
		Map<String, Node> midNodes = new HashMap();
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
				getNextNodes(nd, nextWords, set2, midNodes, wordList);
				if(!midNodes.isEmpty()){
					notFound = false;
				}
			}
			if(!notFound) break;
			set1 = nextWords;
		}
		if(midNodes.isEmpty()){
			return res;
		}
		Map<Node, List<List<String>>> map1 = new HashMap();
		for(Node nd: midNodes.values()){
			List<List<String>> lists = new ArrayList();
			getLists(lists, new ArrayList(), nd);
			map1.put(nd, lists);
		}
		Map<Node, List<List<String>>> map2 = new HashMap();
		for(Node nd: set2){
			if(!midNodes.containsKey(nd.word)) continue;
			List<List<String>> lists = new ArrayList();
			getLists(lists, new ArrayList(), nd);
			map2.put(nd, lists);
		}
		if(bSeq){
			Map<Node, List<List<String>>> tmp = map1;
			map1 = map2;
			map2 = tmp;
		}
		for(Map.Entry<Node, List<List<String>>> ent: map1.entrySet()){
			List<List<String>> list1 = ent.getValue();
			List<List<String>> list2 = map2.get(ent.getKey());
			for(List<String> l1: list1){
				for(List<String> l2: list2){
					LinkedList<String> list = new LinkedList();
					for(String wd: l2){
						list.addFirst(wd);
					}
					list.remove(list.size() - 1);
					list.addAll(l1);
					res.add(list);
				}
			}
		}
		return res;
	}
	
	private static void getLists(List<List<String>> lists, List<String> list, Node node){
		list.add(node.word);
		if(node.nexts.isEmpty()){
			lists.add(new ArrayList<String>(list));
		}else{
			for(Node next: node.nexts){
				getLists(lists, list, next);
			}
		}
		list.remove(list.size() - 1);
	}
	
	private static void getNextNodes(Node node, Set<Node> nextWords, Set<Node> set2, Map<String, Node> midNodes, Set<String> dict){
		StringBuilder sb = new StringBuilder(node.word);
		for(int i = 0; i < sb.length(); i++){
			char ch = sb.charAt(i);
			for(char tmp = 'a'; tmp <= 'z'; tmp++){
				if(tmp == ch) continue;
				sb.setCharAt(i, tmp);
				String tstr = sb.toString();
				Node newNode = new Node(tstr);
				if(set2.contains(newNode)){
					if(midNodes.containsKey(newNode.word)){
						newNode = midNodes.get(newNode.word);
					}else{
						midNodes.put(newNode.word, newNode);
					}
					newNode.nexts.add(node);
				}else if(nextWords.contains(newNode)){
					for(Node nd: nextWords){
						if(nd.word.equals(newNode.word)){
							nd.nexts.add(node);
						}
					}
				}else if(dict.contains(tstr)){
					dict.remove(tstr);
					newNode.nexts.add(node);
					nextWords.add(newNode);
				}
			}
			sb.setCharAt(i, ch);
		}
	}
}
