class Solution {
    int[][] directions=new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    int n,m;
    public int numEnclaves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        dfs(i,j,grid);
                    }
                }
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j]);
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1)
        {
            return;
        }
        grid[i][j]=-1;
        for(int[] direction:directions){
            int new_i=i+direction[0];
            int new_j=j+direction[1];
                if(new_i>=0 && new_i<=n-1 && new_j>=0 && new_j<=m-1 && grid[new_i][new_j]==1){        
                    dfs(new_i,new_j,grid);
                } 
            
        }
    }
    
}