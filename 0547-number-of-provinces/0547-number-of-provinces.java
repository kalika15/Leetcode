class UnionFind{
    private int[] parent;
    private int[] rank;
    private int count=1;
    public UnionFind(int size){
        this.parent=new int[size];
        this.rank=new int[size];
        this.count=size;
        for(int i=0; i<size; i++){
            this.parent[i]=i;
            this.rank[i]=1;
        }
    }
    public int find(int u){
        if(u==this.parent[u]){
            return u;
        }
        return parent[u]=find(parent[u]);
    }
    public void union(int u,int v){
        int p1=find(u);
        int p2=find(v);
        if(p1!=p2){
            if(rank[p1]>rank[p2]){
                this.parent[p2]=p1;
            }
            else if(rank[p1]<rank[p2]){
                this.parent[p1]=p2;
            }
            else{
                parent[p2]=p1;
                rank[p1]+=1;
            }
            this.count-=1;
        }
    }

    public int getCount(){
        return this.count;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind obj=new UnionFind(isConnected.length);
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected.length; j++){
                if(isConnected[i][j]==1){
                    obj.union(i,j);
                }
            }
        }

        return obj.getCount();
    }
}