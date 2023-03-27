class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(m,n,obstacleGrid,dp);
    }
    public int solve(int m,int n,int[][] obstacleGrid,int[][] dp){
        if(dp[m][n]==-1){
            if(m==0 || n==0) dp[m][n]=0;
            else if(obstacleGrid[m-1][n-1]==1) dp[m][n]=0;
            else if(m==1 && n==1) dp[m][n]=1;
            else{
                dp[m][n]=solve(m-1,n,obstacleGrid,dp)+solve(m,n-1,obstacleGrid,dp);
            }
        }
        return dp[m][n];
    }
}