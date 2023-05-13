class Solution {
    int[] dp;
    int mod;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp=new int[high+1];
        Arrays.fill(dp,-1);
        mod=1000000007;
        int ans=0;
        for(int i=low; i<high+1; i++){
            ans=((ans%mod)+(solve(low,high,i,zero,one)%mod))%mod;
        }
        return ans;
        
    }
    public int solve(int low, int high, int i, int zero, int one){
        if(i==0) return 1;
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int a=solve(low,high,i-zero,zero,one);
        int b=solve(low,high,i-one,zero,one);
        return dp[i]=(a+b)%mod;
    }
}