class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s1=new StringBuilder(s);
        StringBuilder sb=s1.reverse();
        String s2=sb.toString();
        int i=s.length()-1;
        int j=s2.length()-1;
        int[][] dp=new int[i+1][j+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return lcs(i,j,s,s2,dp);
    }
    public int lcs(int i,int j,String s,String s2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int match=0;
        int notmatch=0;
        if(s.charAt(i)==s2.charAt(j)){
            match=1+lcs(i-1,j-1,s,s2,dp);
        }
        else{
            notmatch=0+Math.max(lcs(i-1,j,s,s2,dp),lcs(i,j-1,s,s2,dp));
        }
        return dp[i][j]=match+notmatch;
    }
}