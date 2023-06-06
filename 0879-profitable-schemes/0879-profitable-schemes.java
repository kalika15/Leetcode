class Solution {
    int[][][] dp;
    int p;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp=new int[group.length+1][n+1][minProfit+1];
        p=n;
        for(int i=0; i<group.length+1; i++){
            for(int j=0; j<n+1; j++){
                for(int l=0; l<minProfit+1; l++){
                    dp[i][j][l]=Integer.MIN_VALUE;
                }
            }
        }
        return solve(0, n, minProfit, group, profit);
    }
    private int solve(int i, int j, int k, int[] group, int[] profit){
        if(dp[i][j][k]!=Integer.MIN_VALUE) return dp[i][j][k];
        if(i==group.length){
            if(k==0) return 1;
            else return 0;
        }
        int a=0;
        if(j-group[i]>=0){
            a=solve(i+1, j-group[i], Math.max(0,k-profit[i]), group, profit);
        }
        dp[i][j][k]=(solve(i+1, j, k, group,profit)+a)%(1000000007);
        return dp[i][j][k];
    }
}