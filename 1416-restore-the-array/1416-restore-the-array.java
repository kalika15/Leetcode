class Solution {
    int[] dp;
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int mod=1000000007;
        dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1; i>=0; --i){
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            int val=0;
            int j=i;
            dp[i]=0;
            while(j<n && val<=(Integer.MAX_VALUE -s.charAt(j)+'0')/10 && 10*val+s.charAt(j)-'0'<=k){
                val=10*val+s.charAt(j)-'0';
                dp[i]=(dp[i]+dp[j+1])%mod;
                ++j;
            }

        }
        return dp[0];
    }
}