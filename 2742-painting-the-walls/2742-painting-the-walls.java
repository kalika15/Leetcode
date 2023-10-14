class Solution {
    long[][] dp;
    public int paintWalls(int[] cost, int[] time) {
        dp=new long[cost.length][501];
        for(long[] d: dp) Arrays.fill(d,-1);
        return (int)solve(0, cost, time, 0);
    }
    public long solve(int index, int[] cost, int[] time, int total){
        if(total>=cost.length) return 0;
        if(index>=cost.length) return Integer.MAX_VALUE;
        if(dp[index][total]!=-1) return dp[index][total];
        long with=cost[index]+ solve(index+1, cost, time, total+time[index]+1);
        long without=solve(index+1, cost, time, total);
        return dp[index][total]=Math.min(with, without);
    }
}