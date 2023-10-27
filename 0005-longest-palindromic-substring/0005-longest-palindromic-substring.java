class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        dp=new int[n+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        solve(s, 0, n-1);
        int x=0; 
        int y=0;
        for(int i=0; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(dp[i][j]==1 && j-i>y-x){
                    x=i;
                    y=j;
                }
            }
        }
        return s.substring(x,y+1); 
    }
    public int solve(String s, int i, int j){
        if(i==j || i>j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) dp[i][j]=solve(s, i+1, j-1);
        else dp[i][j]=0;
        solve(s, i+1, j);
        solve(s, i, j-1);
        return dp[i][j];
    }
}