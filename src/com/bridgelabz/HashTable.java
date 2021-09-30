package com.bridgelabz;

public class HashTable {
	public static void main(String[] args) {
		LinkedList<String, Integer> linkedlist=new LinkedList<>();
		String message="To be or not to be";
		String[] messagearray=message.toLowerCase().split(" ");
//		[to,be,or,not,be]
//		[t,o,b,e]
		
		for(String word:messagearray) {
			Integer value=linkedlist.get(word);
			if(value==null) {
				value=1;
			}else {
				value++;
			}
			linkedlist.add(word, value);
		}
		System.out.println(linkedlist.toString());
	}

}

