class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp=new long[questions.length+1];
        Arrays.fill(dp,-1);
        solve(questions,0);
        long ans=-1;
        for (int i=0;i<dp.length;i++){
            if (dp[i]>ans){
                ans=dp[i];
            }
        }
        return ans;
    }
    public long solve(int[][] questions, int i){
        if(i>=questions.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        long inc=questions[i][0]+solve(questions,i+questions[i][1]+1);
        long notinc=solve(questions,i+1);
        dp[i]=Math.max(inc,notinc);
        return dp[i];
    }

}