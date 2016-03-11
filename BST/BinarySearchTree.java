package BST;

import StacksBagsQueues.Queue;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {

	private Node root;
	
	private class Node{
		private Key key;
		private Value val;
		private int count;
		private Node left,right;
		
		Node(Key key, Value val){
			this.key = key;
			this.val = val;
		}
	};
	
	public void put(Key key, Value val){
		root = put(root, key, val);
	}
	
	public Node put(Node x, Key key, Value val){
		if(x==null){
			return new Node(key,val);//Case when the tree is empty
		}
		
		int cmp = key.compareTo(x.key);
		
		if(cmp<0){
			x.left = put(x.left, key, val);
		}
		else if(cmp>0){
			x.right = put(x.left, key, val);
		}else{
			x.val = val;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public void delete(Key key){
		Node x = root;
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if(cmp<0){
				x = x.left;
			}else if(cmp>0){
				x = x.right;
			}else{
				
			}
		}
	}
	
	public Value get(Key key){
		Node x = root;
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if(cmp<0){
				x = x.left;
			}else if (cmp>0){
				x = x.right;
			}else{
				return x.val;
			}
		}
		return null;
	}
	
	public Iterable<Key> iterator(){
		Queue<Key> q = new Queue<Key>();
		inorder(q, root);
		return q;
	}
	
	private void inorder(Queue<Key> q, Node x){
		if(x==null){return;}
		inorder(q,x.left);
		q.enqueue(x.key);
		inorder(q,x.right);
	}
	
	private int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x==null){return 0;}
		return x.count;
	}
	
	public int rank(Key k){
		return this.rank(k,this.root);
	}
	
	private int rank(Key k, Node x){
		int cmp = k.compareTo(x.key);
		if(cmp<0){return rank(k,x.left);}
		if(cmp>0){return rank(k,x.right);}
		else{return this.size(x.left);}
	}
}
