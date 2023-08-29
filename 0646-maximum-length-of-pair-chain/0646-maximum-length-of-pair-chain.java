class Solution {
    int[] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> a[0]-b[0]);
        dp=new int[pairs.length];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0; i<pairs.length; i++) ans=Math.max(ans,LongestLengthChain(i,pairs));
        return ans;
    }
    public int LongestLengthChain(int i, int[][] pairs){
        if(i==pairs.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int count=1;
        for(int j=i+1; j<pairs.length; j++){
            if(pairs[j][0]>pairs[i][1]){
                count=Math.max(count,1+LongestLengthChain(j,pairs));
            }
        }
        dp[i]=count;
        return dp[i];
    }
}