class Solution {
    int[][] dp;
    int n;
    int m;
    public int minFallingPathSum(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        if(n==1) return matrix[0][0];
        dp=new int[n+1][m+1];
        for(int i=0; i<n+1 ;i++){
            for(int j=0; j<m+1; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<n ;i++){
            solve(matrix,0,i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            ans=Math.min(dp[0][i],ans);
        }
        return ans;
    }
    public int solve(int[][] matrix, int i, int j){
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        if(i==n-1) return matrix[i][j];
        else{
            if(j==0){
                dp[i][j]=matrix[i][j]+Math.min(solve(matrix,i+1,j),solve(matrix,i+1,j+1));
            }
            else if(j==m-1){
                dp[i][j]=matrix[i][j]+Math.min(solve(matrix,i+1,j-1),solve(matrix,i+1,j));
            }
            else{
                dp[i][j]=matrix[i][j]+Math.min(solve(matrix,i+1,j-1),Math.min(solve(matrix,i+1,j),solve(matrix,i+1,j+1)));
            }
            
        }
        return dp[i][j];
    }
}