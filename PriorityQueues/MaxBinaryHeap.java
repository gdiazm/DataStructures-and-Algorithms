package PriorityQueues;

public class MaxBinaryHeap<Key extends Comparable<Key>> {
	private final Key[] bh;
	private int N;
	
	public MaxBinaryHeap(int capacity){
		bh = (Key[]) new Comparable[capacity+1];//You start in 1
		this.N=0;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void insert(Key k){
		this.bh[++N]=k;
		swim(N);
	}
	
	public Key delMax(){
		exchange(1,N);
		sink(1);
		Key k = this.bh[N];
		this.bh[N--] = null;
		return k;
	}
	
	private void swim(int k){
		while(k>1 && less(k/2,k)){
			exchange(k/2,k);
			k=k/2;
		}
	}
	
	private void sink(int k){
		while(2*k<=N){
			int s = 2*k;
			if(s<N && less(s,s+1)){s++;}
			if(less(s,k)){break;}
			exchange(s,k);
			k=s;
		}
	}
	
	private boolean less(int i, int j){
		return bh[i].compareTo(bh[j])==-1;
	}
	
	private void exchange(int i, int j){
		Key k = this.bh[i];
		this.bh[i] = this.bh[j];
		this.bh[j] = k;
		
	}
}
