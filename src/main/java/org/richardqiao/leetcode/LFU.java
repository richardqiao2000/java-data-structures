package org.richardqiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFU {
    class Node{
        int key, val, freq;
        Node next, prev;
        public Node(int key, int value){
            this.key = key;
            val = value;
            freq = 0;
        }
    }
    Map<Integer, Node> map;
    Node head;
    int CAP, len;
    public LFU(int capacity) {
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        CAP = capacity;
        len = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node nd = map.get(key);
        nd.freq++;
        while(nd.next != null && nd.freq >= nd.next.freq){
            Node prev = nd.prev, next = nd.next;
            prev.next = next;
            next.prev = prev;
            nd.next = next.next;
            nd.prev = next;
            next.next = nd;
            if(nd.next != null) nd.next.prev = nd;
        }
        return nd.val;
    }
    
    public void set(int key, int value) {
        if(CAP == 0) return;
        Node nd;
        if(!map.containsKey(key)){
            if(len == CAP){
                //System.out.println(key + ", " + head.next.key);
                map.remove(head.next.key);
                head.next = head.next.next;
                if(head.next != null) head.next.prev = head;
                len--;
            }
            nd = new Node(key, value);
            map.put(key, nd);
            nd.next = head.next;
            if(nd.next != null) nd.next.prev = nd;
            nd.prev = head;
            head.next = nd;
            len++;
        }
        nd = map.get(key);
        nd.val = value;
        nd.freq++;
        while(nd.next != null && nd.freq >= nd.next.freq){
            Node prev = nd.prev, next = nd.next;
            prev.next = next;
            next.prev = prev;
            nd.next = next.next;
            nd.prev = next;
            next.next = nd;
            if(nd.next != null) nd.next.prev = nd;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LFU cache = new LFU(2);

		cache.set(1, 1);
		cache.set(2, 2);
		cache.get(1);       // returns 1
		cache.set(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.set(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4

	}

}
