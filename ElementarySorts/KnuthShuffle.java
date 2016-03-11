package ElementarySorts;

import java.util.Random;

public class KnuthShuffle {
	
	public static void shuffle(Comparable[] a){
		Random rand = new Random();
		int index;
		for(int i=0; i<a.length; i++){
			index = rand.nextInt(i+1);
			exchange(a,i,index);
		}
	}
	
	public static void exchange(Comparable[] a, int i, int j){
		Comparable aux=a[i];
		a[i]=a[j];
		a[j]=aux;
	}
}
