package ElementarySorts;

public class RecursiveQuickSelect {
	
	public static Comparable select(Comparable[]a, int lo, int hi, int k){
		if(hi<=lo){
			return a[hi];
		}
		
		int pivot = partition(a,lo,hi);
		exchange(a,lo,pivot);
		
		if(pivot==k){
			return a[pivot];
		}else if(pivot>k){
			return select(a,lo,pivot-1,k);
		}else if(pivot<k){
			return select(a,pivot+1,hi,k);
		}
		return a[lo]; //never reaches this point
	}
	
	public static Comparable select(Comparable[]a, int k){
		KnuthShuffle.shuffle(a);
		return select(a,0,a.length-1,k);
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
	
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)==-1;
	}
	
	public static void exchange(Comparable[] a, int i, int j){
		Comparable aux = a[i];
		a[i]=a[j];
		a[j]=aux;
	}
}
