class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
        if(m<n-1) return -1;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int component=0;
        for(int i=0;i<m;i++){
            int p1=findPair(connections[i][0],parent);
            int p2=findPair(connections[i][1],parent);
            if(p1!=p2){
                parent[p1]=p2;
            }
        }
        int leftwire=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                leftwire++;
            }
        }
        
        return leftwire-1;
    }
    public int findPair(int node,int[] parent){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=findPair(parent[node],parent);
    }
}