package PriorityQueues;

public class Heap{
	
	public static void sort(Comparable[] a){
		int N = a.length;
		
		for(int i=N/2; i>=1; i--){
			sink(a, i, N);
		}
		
		while(N>1){
			exchange(a,1,N);
			sink(a,1,--N);
		}
	}
	
	public static void sink(Comparable[] a, int k, int N){
		while(2*k<=N){
			int s = 2*k;
			if(s<N && less(a,s,s+1)){s++;}
			if(less(a,s,k)){break;}
			exchange(a,s,k);
			k=s;
		}
	}
	
	private static boolean less(Comparable[] a, int i, int j){
		return a[i-1].compareTo(a[j-1])==-1;
	}
	private static void exchange(Object[] a, int i, int j){
		Object o = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = o;
	}
}
