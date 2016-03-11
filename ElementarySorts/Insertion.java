package ElementarySorts;

public class Insertion {
	public static void sort(Comparable[] a){
		for(int i=0; i<a.length; i++){
			for(int j=i; j>0; j--){
				if(less(a[j],a[j-1])){
					exchange(a,j,j-1);
				}else{break;}				
			}
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
