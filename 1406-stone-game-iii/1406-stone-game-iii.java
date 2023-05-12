class Solution {
    int[] dp;
    int n;
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int score=solve(stoneValue,0);
        if(score>0) return "Alice";
        if(score<0) return "Bob";
        return "Tie";
        
    }
    public int solve(int[] stoneValue,int i){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int a=stoneValue[i]-solve(stoneValue,i+1);
        int b=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        if(i+1<n) b=stoneValue[i]+stoneValue[i+1]-solve(stoneValue,i+2);
        if(i+2<n) c=stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-solve(stoneValue,i+3);
        dp[i]=Math.max(a,Math.max(b,c));
        return dp[i];
    }
}