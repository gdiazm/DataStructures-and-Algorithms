package ElementarySorts;

public class MergeSort {
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for(int k=lo; k<=hi; k++){
			aux[k]=a[k];
		}
		
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++){
			if(i>mid){a[k]=aux[j++];}
			else if(j>hi){a[k]=aux[i++];}
			else if(less(aux[i],aux[j])){a[k]=aux[i++];}
			else{a[k]=aux[j++];}
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)==-1;
	}
	
	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(hi<=lo){return;}
		int mid=(hi+lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		if(!(less(a[mid+1],a[mid]))){return;}
		merge(a,aux,lo,mid,hi);
	}

}
