package UnionFind;

// QuickFind is too slow for large problems (initialize N, find 1, union N)
public class QuickFindUF {

	int [] id;
	int N;
	
	public QuickFindUF (int N){
		this.N=N;
		for(int i=0; i<N; i++){
			this.id[i]=i;
		}
	}
	
	public boolean connected (int p, int q){
		return id[p] == id[q];
	}
	
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		if(pid != qid){
			id[p] = qid;
			for(int i=0; i<N; i++){
				if(id[i] == pid){
					id[i] = qid;
				}
			}
		}
			
	}
}
