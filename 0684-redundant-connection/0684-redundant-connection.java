class Solution {

    public int find(int u, int[] parent){
        if(u==parent[u]) return u;
        return find(parent[u],parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        for(int i=0; i<edges.length; i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int u=find(edge[0],parent);
            int v=find(edge[1],parent);
            if(u==v){
                return edge;
            }
            parent[v]=u;
        }
        return new int[]{-1,-1};
    }
}