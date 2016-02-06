package StacksBagsQueues;

public class StackExample {
	public static void main(String[] args){
		LinkedStackOfStrings ls= new LinkedStackOfStrings();
		ls.push("Hello");
		ls.push("world");
		ls.push("first");
		ls.push("test");
		ls.display();
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());

		ArrayStackOfStrings as= new ArrayStackOfStrings(10);
		as.push("Hello");
		as.push("world");
		as.push("second");
		as.push("test");
		as.display();
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		
		
		ResizingArrayStackOfStrings ras= new ResizingArrayStackOfStrings(4);
		ras.push("Hello");
		ras.push("world");
		ras.push("third");
		ras.push("and last");
		System.out.println(ras.size());
		ras.push("test");
		System.out.println(ras.size());
		ras.display();
		System.out.println(ras.pop());
		System.out.println(ras.pop());
		System.out.println(ras.size());
		System.out.println(ras.pop());
		System.out.println(ras.size());
		System.out.println(ras.pop());
		
	}
}
