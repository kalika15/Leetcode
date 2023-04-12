class Solution {
    int m, n;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        return solve(0, 0, dungeon, dp);
    }

    private int solve(int i, int j, int[][] dungeon, int[][] dp) {
        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        if (i == m - 1 && j == n - 1)
            return dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
        else if (i == m - 1)
            return dp[i][j] = Math.max(1, solve(i, j + 1, dungeon, dp) - dungeon[i][j]);
        else if (j == n - 1)
            return dp[i][j] = Math.max(1, solve(i + 1, j, dungeon, dp) - dungeon[i][j]);
        else
            return dp[i][j] = Math.max(1,
                    Math.min(solve(i, j + 1, dungeon, dp) - dungeon[i][j], solve(i + 1, j, dungeon, dp) - dungeon[i][j]));

    }
}
