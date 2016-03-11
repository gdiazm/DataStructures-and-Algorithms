package HashTables;

import java.util.ArrayList;
import java.util.Collection;

public class SeparateChainingHT<Key, Value> {
	int M = 31; //size of the HT
	Node[] hashTable = new Node[M];
	
	private static class Node {
		private Node next;
		private Object key, val;
	}

	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	

	public void put(Key k, Value v){
		int pos = this.hash(k);
		Node search = this.hashTable[pos];
		while(search!=null){
			if(search.key.equals(k)){
				search.val = v;
				return;
			}
			search = search.next;
		}
		Node n = new Node();
		n.key = k;
		n.val = v;
		n.next = this.hashTable[pos];
		this.hashTable[pos] = n;
	}
	
	public Value get(Key key){
		Node x = this.hashTable[(this.hash(key))];
		while(x!=null){
			if(x.key.equals(key)){
				return (Value)x.val;
			}
			x = x.next;
		}
		return null;
	}

	public Iterable<Key> keys() {
		Collection<Key> c = new ArrayList<Key>();
		for(int i=0; i<M; i++){
			for(Node x = this.hashTable[i]; x != null; x = x.next){
				c.add((Key) x.key);
			}
		}
		
		return c;
	}
}
