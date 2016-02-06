package StacksBagsQueues;

public class LinkedStackOfStrings {
private Node first=null;

	private class Node{
		Node next;
		String item;
	}
	
	void push(String item){
		Node oldFirst=this.first;
		Node first = new Node();
		first.item=item;
		first.next=oldFirst;
		this.first=first;
	}
	
	String pop(){
		Node oldFirst = this.first;
		Node first = oldFirst.next;
		String item = oldFirst.item;
		oldFirst = null;
		this.first=first;
		return item;
	}
	
	boolean isEmpty(){
		return this.first==null;
	}
	
	void display(){
		Node curr = this.first;
		while(curr!=null){
			System.out.println(curr.item);
			curr=curr.next;
		}
				
	}
}
