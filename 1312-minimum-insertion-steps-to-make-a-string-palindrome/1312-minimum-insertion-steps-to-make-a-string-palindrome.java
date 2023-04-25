class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] i: dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        return solve(s,0,n-1,dp);

    }
    public int solve(String s, int i,int j, int[][] dp){
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        if(i==j) return dp[i][j]=0;
        else if(j==i+1){
            if(s.charAt(i)==s.charAt(j)) return dp[i][j]=0;
            else if(s.charAt(i)!=s.charAt(j)) return dp[i][j]=1;
        }
        else {
            dp[i][j]=Math.min(1+solve(s,i+1,j,dp),1+solve(s,i,j-1,dp));
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=Math.min(dp[i][j],solve(s,i+1,j-1,dp));
            }
        }
        return dp[i][j];

    }
}