package StacksBagsQueues;

public class LinkedQueueOfStrings{
	private Node first,last;
	
	private class Node{
		private String item;
		private Node next;
	}
	
	void enqueue(String item){
		if(this.isEmpty()){
			Node newNode = new Node();
			newNode.item = item;
			newNode.next=null;
			this.first = newNode;
			this.last = this.first;
		}else{
			Node oldLast = this.last;
			Node newLast = new Node();
			newLast.item = item;
			newLast.next=null;
			oldLast.next=newLast;
			this.last=newLast;
		}
	}
	
	String dequeue(){
		String item=null;
		if(!this.isEmpty()){
			Node oldFirst = this.first;
			Node newFirst = oldFirst.next;
			this.first = newFirst;
			item=oldFirst.item;
		}
		return item;
	}
	
	boolean isEmpty(){
		return this.first==null;
	}
	
	void display(){
		Node curr = this.first;
		while(curr!=null){
			System.out.println(curr.item);
			curr = curr.next;
		}
	}
}
