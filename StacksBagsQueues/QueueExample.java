package StacksBagsQueues;

public class QueueExample {
	public static void main(String[] args){
		LinkedQueueOfStrings lq = new LinkedQueueOfStrings();
		lq.enqueue("Hello");
		lq.enqueue("world");
		lq.enqueue("first");
		lq.enqueue("test");
		lq.display();
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
		
		
		ResizingArrayQueueOfStrings raq = new ResizingArrayQueueOfStrings(3);
		raq.enqueue("Hello");
		raq.enqueue("world");
		raq.enqueue("second");
		raq.enqueue("and last");
		System.out.println(raq.size());
		raq.enqueue("test");
		System.out.println(raq.size());
		raq.display();
		System.out.println(raq.dequeue());
		System.out.println(raq.dequeue());
		System.out.println(raq.size());
		System.out.println(raq.dequeue());
		System.out.println(raq.size());
		System.out.println(raq.dequeue());
	}
}
