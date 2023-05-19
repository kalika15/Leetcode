class Solution {
    int[][] dp;
    public int countVowelStrings(int n) {
        dp=new int[n+1][6];
        return solve(n,5);
    }
    private int solve(int n,int v){
        if(n==1) return v;
        if(v==1) return 1;
        if(dp[n][v]!=0) return dp[n][v];
        return dp[n][v]=solve(n-1,v)+solve(n,v-1);
    }
}