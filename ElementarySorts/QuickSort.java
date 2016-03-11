package ElementarySorts;

public class QuickSort {

	public static void sort(Comparable[] a, int lo, int hi){
		if(lo>=hi){return;}
		int k= partition(a, lo ,hi);
		exchange(a, lo, k);
		sort(a, lo, k-1);
		sort(a, k+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo;
		int j = hi+1;
		
		while(true){
			while(less(a[++i],a[lo])){
				if(i==hi){break;}
			}
			
			while(less(a[lo],a[--j])){
				if(j==lo){break;}
			}
			
			if(i>=j){break;}
			
			exchange(a, i, j);
		}
		return j;
	}
	
	public static void sort(Comparable[] a){
		KnuthShuffle.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)==-1;
	}
	
	public static void exchange(Comparable[] a, int i, int j){
		Comparable aux = a[i];
		a[i]=a[j];
		a[j]=aux;
	}
}
