class Solution {
    int[][] direction=new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        int mod = 1000000007;
        int[][] dp=new int[n+1][10];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<10; j++){
                dp[i][j]=1;
            }
        }
        for(int row=2;row<=n;row++){
            for(int i=0;i<10;i++){
                dp[row][i]=0;
                for(int j : direction[i]){
                    dp[row][i]=(dp[row][i]+dp[row-1][j])%mod;
                }
            }
        }
        int ans=0;
        for(int i=0;i<10;i++){
            ans=(ans+dp[n][i])%mod;
        }
        return ans;
    }
}