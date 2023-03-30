class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove<0) return 0;
        int[][] dp=new int[m][n];
        int mod = 1000000007;
        dp[startRow][startColumn]=1;
        int count=0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int round=0;round<maxMove;round++){
            int[][] temp=new int[m][n];
            for(int r=0;r<m;r++){
                for(int c=0;c<n;c++){
                    for(int[] dir:dirs){
                        int newrow=r+dir[0];
                        int newcol=c+dir[1];
                        if(newrow<0 || newrow>=m || newcol<0 || newcol>=n){
                            count=(count+dp[r][c])%mod;
                        }
                        else if (newrow>=0 && newrow<m && newcol>=0 && newcol<n){
                            temp[newrow][newcol]=(temp[newrow][newcol]+dp[r][c])%mod;
                        }
                    }
                }
            }
            dp=temp;
        }
        return count;
    }
}