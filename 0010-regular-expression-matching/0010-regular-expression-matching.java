class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(0,s,0,p,dp);
    }
    boolean solve(int i, String s, int j, String p, Boolean[][] dp){
        if(j==p.length()) return i==s.length();
        if(dp[i][j]!=null) return dp[i][j];
        boolean temp=i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            dp[i][j]=(temp && solve(i+1,s,j,p,dp) || solve(i,s,j+2,p,dp));
        }
        else dp[i][j]=temp && solve(i+1,s,j+1,p,dp);
        return dp[i][j];
    }
}
