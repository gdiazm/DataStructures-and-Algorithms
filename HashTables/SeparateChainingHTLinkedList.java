package HashTables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SeparateChainingHTLinkedList<Key, Value>{
	private int M = 31;
	private SequentialSearchST<Key, Value>[] st;
	
	
	public SeparateChainingHTLinkedList(int M){
		this.M = M;
		this.st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0; i<M; i++){
			st[i] = new SequentialSearchST<Key,Value>();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(Key k, Value v){
		int pos = this.hash(k);
		st[pos].put(k, v);
	}
	
	public Value get(Key k){
		int pos = this.hash(k);
		return st[pos].get(k);
	}
	
	public Iterable<Key> keys(){
		Collection<Key> c = new ArrayList<Key>();
		for(int i=0; i<st.length; i++){
			for(Key key: st[i].keys()){
				c.add(key);
			}
		}
		return c;
	}
}
