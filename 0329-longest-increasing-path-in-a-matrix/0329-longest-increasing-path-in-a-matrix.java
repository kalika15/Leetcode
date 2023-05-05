class Solution {
    int[][] dp;
    int n;
    int m;
    int[][] direction=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        dp=new int[n][m];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int a=solve(matrix,i,-1,j);
                ans=Math.max(ans,a);
            }
        }
        return ans;
    }
    public int solve(int[][] matrix, int i,int prev, int j){
        if(i<0 || j<0 || i>=n || j>=m|| matrix[i][j]<=prev) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        for(int[] dir:direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            int a=1+solve(matrix,new_i,matrix[i][j],new_j);
            ans=Math.max(ans,a);
        }
        return dp[i][j]=ans;
    }
}