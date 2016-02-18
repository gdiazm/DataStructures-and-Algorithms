package StacksBagsQueues;

public class Evaluate {
	public static void main (String[] args){
		GenericLinkedListStack<Double> valStack = new GenericLinkedListStack<Double>();
		GenericLinkedListStack<String> opStack = new GenericLinkedListStack<String>();
		
		String expr="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
		
		for(int i=0; i<expr.length(); i++){
			String comp = expr.substring(i,i+1);
			if(!comp.equals(" ")){
				if(comp.equals("("));
				else if(comp.equals("+")){
					opStack.push("+");
				}
				else if(comp.equals("*")){
					opStack.push("*");
				}
				else if(comp.equals(")")){
					double val1 = valStack.pop();
					double val2 = valStack.pop();
					String op = opStack.pop();
					valStack.push(op.equals("+")?val1+val2:val1*val2);
				}
				else{
					valStack.push(Double.parseDouble(comp));
				}
			}
		}
			
		System.out.println("solution: "+valStack.pop());
	
	}
}
