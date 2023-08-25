class Solution {
    Boolean[][][] dp;
    
    public boolean isValid(int i, int j, int z, String s1, String s2, String s3) {
        if (i==s1.length() && j==s2.length() && z==s3.length()) {
            return true;
        }

        if (dp[i][j][z] != null) {
            return dp[i][j][z];
        }

        boolean valid1=false, valid2=false;

        if (i<s1.length() && s1.charAt(i) == s3.charAt(z)) {
            valid1 = isValid(i+1, j, z+1, s1, s2, s3);
        }
        if (j<s2.length() && s2.charAt(j) == s3.charAt(z)) {
            valid2 = isValid(i, j+1, z+1, s1, s2, s3);
        }

        dp[i][j][z] =valid1 || valid2;
        return dp[i][j][z];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length()+s2.length())) {
            return false;
        }

        dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return isValid(0, 0, 0, s1, s2, s3);
    }
}
