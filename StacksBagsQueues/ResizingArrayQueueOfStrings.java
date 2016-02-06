package StacksBagsQueues;

public class ResizingArrayQueueOfStrings {
	private String[] array;
	private int head=0, tail=0;
	
	ResizingArrayQueueOfStrings(int N){
		this.array = new String[N];
	}
	
	void enqueue(String item){
		if(this.tail>=this.array.length){
			int size=this.tail-this.head>=this.array.length?2:1;
			String[] biggerArray = new String[size*this.array.length];
			int j = 0;
			for(int i=0; i<this.array.length; i++){
				if(this.array[i]!=null){
					biggerArray[j] = this.array[i];
					j++;
				}
			}
			this.array = biggerArray;
		}
		this.array[this.tail++] = item;
	}
	
	String dequeue(){
		if(this.tail-this.head<=this.array.length/4){
			String[] biggerArray = new String[this.array.length/2];
			int j = 0;
			for(int i=0; i<this.array.length; i++){
				if(this.array[i]!=null){
					biggerArray[j] = this.array[i];
					j++;
				}
			}
			this.array = biggerArray;
		}	
		String item = this.array[this.head];
		this.array[this.head++]=null;
		return item;
	}
	
	boolean isEmpty(){
		return this.head==this.tail;
	}
	
	void display(){
		for(int i=this.head; i<this.tail; i++){
			System.out.println(this.array[i]);
		}
	}
	
	int size(){
		return this.array.length;
	}
}
