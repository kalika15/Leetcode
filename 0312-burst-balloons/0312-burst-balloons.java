class Solution {
    int n;
    public int maxCoins(int[] nums) {
        n=nums.length;
        int[] a=new int[n+2];
        a[0]=a[n+1]=1;
        for(int i=0; i<n; i++){
            a[i+1]=nums[i];
        }
        int[][] dp=new int[n+2][n+2];
        for(int[] i:dp){
            Arrays.fill(i,Integer.MIN_VALUE);
        }
        return solve(1,n,dp,a);
    }
    private int solve(int i,int j,int[][] dp,int[] a){
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        if(j==i-1) return dp[i][j]=0;
        else if( j==i) return dp[i][j]=a[i-1]*a[i]*a[i+1];
        else{
            dp[i][j]=0;
            for(int k=i;k<=j ;k++){
                dp[i][j]=Math.max(dp[i][j],a[i-1]*a[k]*a[j+1]+solve(i,k-1,dp,a)+solve(k+1,j,dp,a));
            }
        }
        return dp[i][j];
        
    }
}