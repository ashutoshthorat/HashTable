package com.bridgelabz;

import java.util.ArrayList;

public class LinkedList<K,V> {
	Node head;
	Node tail;

	private final int numOfBuckets;
	ArrayList<Node<K,V>> myBucketArray;
	public LinkedList() {
		this.numOfBuckets = 20;
		myBucketArray=new ArrayList<Node<K,V>>();
		for(int i=0;i<numOfBuckets;i++) {
			myBucketArray.add(null);
		}
	}
	
	
	public void add(K key,V value) {
		int index=getKeyIndex(key);
		Node<K,V> node=myBucketArray.get(index);
		if(node==null) {
			node=new Node<>(key, value);
			myBucketArray.set(index, node);
		}
		node=searchNode(key);
		if(node==null) {
			node=new Node<>(key,value);
			append(node);
			
		}
		else {
			node.setValue(value);
		}	
	}
	
	private void append(Node<K, V> node) {
		if(head==null) {
			head=node;
		}
		if(tail==null) {
			tail=node;
		}
		else {
			tail.setNext(node);
			tail=node;
		}
		
	}
	
	
	
	public V get(K key) {
		
		int index=getKeyIndex(key);
		if(myBucketArray.get(index)==null) {
			return null;
		}
		Node<K,V> node=searchNode(key);
		return (node == null)?null:node.getValue();
		
		
	}


	private Node<K, V> searchNode(K key) {
		Node node=head;
		int countposition=0;
		while(node !=null) {
			countposition++;
			if(node.getKey().equals(key)) {
				return node;
			}
			node=node.getNext();
		}
		// TODO Auto-generated method stub
		return node;
	}


	public int getKeyIndex(K word) {
		int hashcode=Math.abs(word.hashCode());
		int index=hashcode%numOfBuckets;
		return index;
		
	}
	
	public void remove(K word) {
		Node currentnode=head;
		Node previousnode=null;
		while(currentnode!=null && currentnode.getNext().equals(word)) {
			head=currentnode.getNext();
		}
		
		while(currentnode!=null && !currentnode.getNext().equals(word)) {
			previousnode=currentnode;
			currentnode=currentnode.getNext();
		}
		if(currentnode!=null) {
			previousnode.next=currentnode.next;
		}
		if(currentnode==null) {
			System.out.println("words not found");
		}
		
		
	}
	public String toString() {
		return "Mylist{"+ head+"}";
	}
}
