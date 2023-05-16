class Solution {
    int[][] dp;
    int n;
    public boolean stoneGame(int[] piles) {
        n=piles.length;
        dp=new int[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n ;j++){
                if(j>=i){
                    int val1=0, val2=0;
                    if(i+1<n){
                        val1=dp[i+1][j];
                    }
                    if(j-1>=0){
                        val2=dp[i][j-1];
                    }
                    dp[i][j]=Math.max(piles[i]-val1,piles[j]-val2);
                }
            }
        }
        int ans=dp[0][n-1];
        if(ans>0) return true;
        return false;
    }
    // public int solve(int[] piles,int left,int right){
    //     if(dp[left][right]!=-1) return dp[left][right];
    //     if(left==right) return piles[left];
    //     int a=piles[left]-solve(piles,left+1,right);
    //     int b=piles[right]-solve(piles,left,right-1);
    //     dp[left][right]=Math.max(a,b);
    //     return dp[left][right];
    // }
}