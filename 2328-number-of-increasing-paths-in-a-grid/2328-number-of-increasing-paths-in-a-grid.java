class Solution {
    int[][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int[][] dfstbl;
    int n;
    int m;
    public int countPaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dfstbl=new int[n][m];
        for(int[] i:dfstbl){
            Arrays.fill(i,-1);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfstbl[i][j]=dfs(grid,i,j,-1);

            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // System.out.print(dfstbl[i][j]);
                ans=(ans+dfstbl[i][j])%(1000000007);
            }
        }
        return ans%(1000000007);

    }
    public int dfs(int[][] grid,int row, int col,int prev){
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]<=prev){
            return 0;
        }
        if (dfstbl[row][col]!=-1) return dfstbl[row][col];
        int c=1;
        for(int[] dir:directions){
            int curr_row=row+dir[0];
            int curr_col=col+dir[1];
            c=(c+dfs(grid,curr_row,curr_col,grid[row][col]))%(1000000007);
        }
        dfstbl[row][col]=c%(1000000007);
        return c%(1000000007);
    }
}