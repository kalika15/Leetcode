class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0);

    }
    public int solve(String s, int i){
        if(i>=n) return 1;
        else{
            if(s.charAt(i)=='0'){
                return 0;
            }
            if(dp[i]!=-1) return dp[i];
            int l=0,r=0;
            l=solve(s,i+1);
            if(i<n-1){
                String temp=s.substring(i,i+2);
                int num=Integer.parseInt(temp);  
                if(num>=0 && num<=26){
                    r=solve(s,i+2);
                }
            }
            dp[i]=l+r;
            return dp[i];
        }
    }
}