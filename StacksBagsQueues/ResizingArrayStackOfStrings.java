package StacksBagsQueues;

public class ResizingArrayStackOfStrings {
	private String[] array;
	private int openPosition=0;
	
	ResizingArrayStackOfStrings(int N){
		this.array = new String[N];
	}
	
	void push(String item){
		if(this.openPosition>=this.array.length){
			String[] newArray= new String[2*this.array.length];
			for(int i=0; i<this.array.length; i++){
				newArray[i]=this.array[i];
			}
			this.array=newArray;
		}
		this.array[this.openPosition++]=item;
	}
	
	String pop(){
		String item = this.array[--this.openPosition];
		this.array[this.openPosition] = null;
		if(this.openPosition<=this.array.length/4){
			String[] newArray= new String[this.array.length/2];
			for(int i=0; i<this.array.length/2; i++){
				newArray[i]=this.array[i];
			}
			this.array=newArray;
		}
		return item;
	}
	
	boolean isEmpty(){
		return this.openPosition==0;
	}
	
	void display(){
		for(int i=0; i<openPosition; i++){
			System.out.println(this.array[i]);
		}
	}
	
	int size(){
		return this.array.length;
	}
}
