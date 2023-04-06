class Solution {
    int[][] directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int n,m;
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int c=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0 && dfs(i,j,grid)){
                    c++;
                }
            }
        }
        return c;
        
    }
    public boolean dfs(int i, int j,int[][] grid){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        if (grid[i][j]==1) return true;
        grid[i][j]=1;
        boolean flag=true;
        for(int[] direction:directions){
            int new_i=i+direction[0];
            int new_j=j+direction[1];
            flag&=dfs(new_i,new_j,grid);
            
        }
        return flag;
    }
}