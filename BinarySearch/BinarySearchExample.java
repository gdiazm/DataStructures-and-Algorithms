package BinarySearch;

public class BinarySearchExample {

	public static void main(String args[]){
		int[] arr={1,2,3,4,5,6};
		int index=binarySearch(arr,4);
		String s= index==-1?"Not found":"Element found at position "+index;
		System.out.println(s);
	}
	
	public static int binarySearch(int[] a, int key){
		int lo=0, hi=a.length-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(key<a[mid]){
				hi=mid-1;
			}else{
				if(key>a[mid]){
					lo=mid+1;
				}else{
					return mid;
				}
			}
		}
		return -1;
	}
}
