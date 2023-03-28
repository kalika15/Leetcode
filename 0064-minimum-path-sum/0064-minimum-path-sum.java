// bottom up approach o(mn)
class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=n-1 ;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i+1 == n && j+1 == m) {
                    dp[i][j] = grid[i][j];
                } else if (j+1 == m) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if (i+1 == n) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}