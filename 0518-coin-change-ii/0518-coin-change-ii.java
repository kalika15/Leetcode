class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        int ans=solve(n-1, amount , coins);
        return ans;
    }
    public int solve(int i, int amount, int[] coins){
        if(i==0){
            if(amount% coins[0]==0) return 1;
            return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick=0;
        int notpick=0;
        if(coins[i]<=amount){
            pick=solve(i, amount-coins[i], coins);
        }
        notpick=solve(i-1, amount, coins);
        return dp[i][amount]=pick+notpick;
    }
}