class Solution {
    int m,n;
    public int findCircleNum(int[][] isConnected) {
        m=isConnected.length;
        n=isConnected[0].length;
        int[] visited=new int[m];
        int c=0;
        for(int i=0;i<m;i++){
            visited[i]=0;
        }
        for(int i=0;i<m;i++){
            if(visited[i]==0){
                dfs(i,visited,isConnected);
                c++;
            }
        }
        return c;
    }
    public void dfs(int k,int[] visited,int[][] isConnected){
        if(visited[k]!=0){
            return;
        }
        visited[k]=1;
        for(int i=0;i<n;i++){
            if(isConnected[k][i]==1){
                    dfs(i,visited,isConnected);
            }
        }
    }
}