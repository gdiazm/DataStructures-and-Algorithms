package HashTables;

import java.util.ArrayList;
import java.util.Collection;

public class LinearProbingHashTable<Key, Value> {
	private int N, M;
	private Key[] keys;
	private Value[] values;
	private Collection<Integer> tombStones;
	
	public LinearProbingHashTable(){
		this.M = 5;
		this.N = 0;
		this.keys = (Key[]) new Object[M];
		this.values = (Value[]) new Object[M];
		tombStones = new ArrayList<Integer>();
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put (Key k, Value v){
		int pos = this.hash(k);
		int i = pos;
		for(i=pos; this.keys[i]!=null; i = (i+1)%M){
			if(this.keys[i].equals(k)){
				this.values[i] = v;
				return;
			}
		}
		this.keys[i] = k;
		this.values[i] = v;
		this.N++;
		if(this.tombStones.contains(new Integer(i))){this.tombStones.remove(new Integer(i));}
		if(this.N>=this.M/2){this.doubleSize();}
	}
	
	private void doubleSize(){
		Key[] k = (Key[]) new Object[M*2];
		Value[] v = (Value[]) new Object[M*2];
		this.M*=2;
		
		for(int i=0; i<M/2; i++){
			if(this.keys[i]!=null){
				k[this.hash(this.keys[i])] = this.keys[i];
				v[this.hash(this.keys[i])] = this.values[i];
			}
		}
		this.tombStones.clear();
		
		this.keys = k;
		this.values = v;
		
	}
	
	public Value get(Key k){
		int pos = this.hash(k);
		for(int i=pos; this.keys[i]!=null||this.tombStones.contains(new Integer(i)); i = (i+1)%M){
			if(this.keys[i].equals(k)){return this.values[i];}
		}
		return null;
	}
	
	public void delete(Key k){
		int pos = this.hash(k);
		for(int i=pos; this.keys[i]!=null||this.tombStones.contains(new Integer(i)); i = (i+1)%M){
			if(this.keys[i].equals(k)){
				this.keys[i] = null;
				this.values[i] = null;
				this.tombStones.add(new Integer(i));
				this.N--;
				return;
			}
		}
	}
	
	public Iterable<Key> keys(){
		Collection c = new ArrayList<Key>();
		for(int i=0 ; i<M; i++){
			if(this.keys[i]!=null){c.add(this.keys[i]);}
		}
		return c;
	}
}
