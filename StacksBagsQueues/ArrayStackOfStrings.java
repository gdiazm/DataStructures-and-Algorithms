package StacksBagsQueues;

public class ArrayStackOfStrings {
	private String[] array;
	private int openPosition=0;
	
	ArrayStackOfStrings(int N){
		this.array = new String[N]; 
	}
	
	void push(String item){
		this.array[this.openPosition] = item;
		this.openPosition++;
	}
	
	String pop(){
		String item = this.array[--this.openPosition];
		this.array[this.openPosition]=null;
		return item;
	}
	
	boolean isEmpty(){
		return this.openPosition==0;
	}
	
	void display(){
		for(int i=openPosition-1; i>=0; i--){
			System.out.println(this.array[i]);
		}
	}
}
