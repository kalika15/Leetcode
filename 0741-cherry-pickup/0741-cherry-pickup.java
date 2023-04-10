class Solution {
    int n;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        dp=new int[n][n][n];                                                                    
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        int ans= f1(n-1,n-1,n-1,n-1,grid);
        if(ans==-1) return 0;
        return ans;
    }
    private int f1(int i1,int j1,int i2,int j2,int[][] grid){
        if(i1==0 && j1==0 && i2==0 && j2==0) return grid[0][0];
        if(i1<0 || j1<0 || i2<0 || j2<0 || grid[i1][j1]==-1 || grid[i2][j2]==-1){
            return -1;
        }
        if(dp[i1][j1][i2]!=Integer.MIN_VALUE) return dp[i1][j1][i2];
        int ans=0;
        if(i1!=i2){
            if (grid[i1][j1]==1) ans+=1;
            if (grid[i2][j2]==1) ans+=1;
        }
        else{
            if(grid[i1][j1]==1) ans+=1;
        }
        int ans2=Math.max(f1(i1-1,j1,i2-1,j2,grid),f1(i1-1,j1,i2,j2-1,grid));
        int ans3=Math.max(f1(i1,j1-1,i2-1,j2,grid),f1(i1,j1-1,i2,j2-1,grid));
        ans2=Math.max(ans2,ans3);
        if(ans2==-1) return dp[i1][j1][i2]= -1;
        return dp[i1][j1][i2]=ans+ans2;
    }
}