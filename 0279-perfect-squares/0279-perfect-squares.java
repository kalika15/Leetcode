// Unbounded knapsack
class Solution {
    int[][] dp;
    public int numSquares(int n) {
        List<Integer> arr=new ArrayList<>();
        int num=1;
        while(num*num<=n){
            int sq=num*num;
            num+=1;
            arr.add(sq);
        }
        dp=new int[arr.size()+1][n+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return knapsack(arr,n,arr.size());
    }
    private int knapsack(List<Integer> wt, int W, int n){
        if(n==0 && W==0) return 0;
        if(n==0) return Integer.MAX_VALUE;
        if(W==0) return 0;
        if(dp[n][W]!=-1) return dp[n][W];
        if(wt.get(n-1)>W) return dp[n][W]=knapsack(wt,W,n-1);
        return dp[n][W]=Math.min(1+knapsack(wt,W-wt.get(n-1),n),knapsack(wt,W,n-1));
    }
}