package StacksBagsQueues;

public class GenericLinkedListStack<Item>{
	private Node first;
	
	private class Node{
		private Item item;
		private Node next;
	}
	
	void push (Item item){
		Node oldFirst = this.first;
		Node newFirst = new Node();
		newFirst.item = item;
		newFirst.next = oldFirst;
		this.first = newFirst;
	}
	
	Item pop(){
		Node oldFirst = this.first;
		Item item = oldFirst.item;
		Node newFirst = oldFirst.next;
		this.first=null;
		this.first = newFirst;
		return item;
	}
	
	boolean isEmpty(){
		return this.first==null;
	}
	
	void display(){
		Node curr = this.first;
		while(curr!=null){
			System.out.println(curr.item.toString());
			curr = curr.next;
		}
	}
	
}
