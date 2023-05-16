class Solution {
    int[][] dp;
    int n;
    public boolean stoneGame(int[] piles) {
        n=piles.length;
        dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int ans=solve(piles,0,n-1);
        if(ans>0) return true;
        return false;
    }
    public int solve(int[] piles,int left,int right){
        if(dp[left][right]!=-1) return dp[left][right];
        if(left==right) return piles[left];
        int a=piles[left]-solve(piles,left+1,right);
        int b=piles[right]-solve(piles,left,right-1);
        dp[left][right]=Math.max(a,b);
        return dp[left][right];
    }
}