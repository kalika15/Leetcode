class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        int largest=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    largest=Math.max(largest,dp[i][j]);
                }
            }
        }
        return largest*largest;
    }
}