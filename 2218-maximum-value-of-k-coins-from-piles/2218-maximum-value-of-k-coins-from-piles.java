class Solution {
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp=new int[piles.size()][k+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return solve(0, piles, k);
    }

    public int solve(int ind, List<List<Integer>> piles, int k){
        if(k==0) return 0;
        if(piles.size()==ind) return Integer.MIN_VALUE;
        if(dp[ind][k]!=-1) return dp[ind][k];
        int res=solve(ind+1,piles,k);
        int temp=0;
        for(int i=0; i<Math.min(k,piles.get(ind).size()); i++){
            temp+=piles.get(ind).get(i);
            res=Math.max(res,temp+solve(ind+1, piles, k-(i+1)));
        }
        dp[ind][k]=res;
        return res;
    }
}