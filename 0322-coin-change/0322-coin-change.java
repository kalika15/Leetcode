class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int res=solve(coins , amount);
        if(res==Integer.MAX_VALUE) return -1;
        return res;
    }
    public int solve(int[] coins , int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int res=Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int temp=solve(coins, amount-coins[i]);
                if(temp!=Integer.MAX_VALUE){
                    res=Math.min(res, temp+1);
                }
            
        }
        dp[amount]=res;
        return res;
    }
}