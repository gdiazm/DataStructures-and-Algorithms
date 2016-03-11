package ElementarySorts;

public class Selection {
	
	public static void sort(Comparable[] a){
		for(int i=0; i<a.length ;i++){
			int min = i;
			for(int j=i+1; j<a.length; j++){
				if(less(a[j],a[min]))
					min=j;
			}
			exchange(a,i,min);
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)==-1;
	}
	
	public static void exchange(Comparable[] a, int i, int j){
		Comparable aux=a[i];
		a[i]=a[j];
		a[j]=aux;
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=0; i<a.length-1; i++){
			if(less(a[i+1],a[i]))
				return false;
		}
		return true;
	}
}
