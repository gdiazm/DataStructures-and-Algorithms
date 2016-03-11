package ElementarySorts;

public class Shell {
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h<N/3){ h*= 3*h+1;}
		
		while(h>=1){
			for(int i=h; i<N; i++){
				for(int j=i; j-h>=0; j=j-h){
					if(less(a[j],a[j-h]))
						exchange(a,j,j-h);
					else break;
				}
			}
			h/=3;
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
