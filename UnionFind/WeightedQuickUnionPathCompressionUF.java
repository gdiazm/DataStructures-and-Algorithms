package UnionFind;

public class WeightedQuickUnionPathCompressionUF {
private int[] id;
private int[] size;
	
	public WeightedQuickUnionPathCompressionUF(int N){
		for(int i=0; i<N; i++){
			id[i]=i;
			size[i]=1;
		}
	}
	
	public int root(int p){
		while(id[p]!=p){
			id[p]=id[id[p]];
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
			if(size[p]>size[q]){
				id[qroot] = proot;
				size[p]+=size[q];
			}
			else{
				id[proot] = qroot;
				size[q]+=size[p];
			}
		}
	}
}	
