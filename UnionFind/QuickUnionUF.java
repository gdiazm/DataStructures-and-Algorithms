package UnionFind;

//QuickUnion is too slow for large problems (initialize N, find N, union N) in the worst case
public class QuickUnionUF {
	private int[] id;
	
	public QuickUnionUF(int N){
		for(int i=0; i<N; i++){
			id[i]=i;
		}
	}
	
	public int root(int p){
		while(id[p]!=p){
			p = id[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q){
		return root(p)==root(q);
	}
	
	public void union(int p, int q){
		int proot = root(p);
		int qroot = root(q);
		if(proot!= qroot){
			id[proot] = qroot;
		}
	}
	
}
