package UnionFind;

import java.util.Scanner;

public class UnionFindExample {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		UF uf = new UF(n);
		for(int i=0; i<n; i++){
			int p = in.nextInt();
			int q = in.nextInt();
			if(!uf.connected(p,q)){
				uf.union(p,q);
				System.out.println(p+ " " +q);
			}
		}
		in.close();
	}
}
