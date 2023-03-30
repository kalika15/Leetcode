class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(m,n,dp);
    }
    public int solve(int m,int n,int[][] dp){
        if(dp[m][n]==-1){
            if(m==0 || n==0) dp[m][n]=0;
            else if(m==1 && n==1) dp[m][n]=1;
            else{
                dp[m][n]=solve(m-1,n,dp)+solve(m,n-1,dp);
            }
        }
        return dp[m][n];
    }

}