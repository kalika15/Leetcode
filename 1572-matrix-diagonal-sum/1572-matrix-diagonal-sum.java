class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int leftdiagonal=0;
        int rightdiagonal=0;

        for(int i=0; i<n; i++){
            if(i==(n-i-1)){
                leftdiagonal+=mat[i][i];
                continue;
            }
            leftdiagonal+=mat[i][i];
            rightdiagonal+=mat[i][n-i-1];
        }
        return leftdiagonal+rightdiagonal;
    }
}