class Solution {
    public int[][] transpose(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] result=new int[m][n];
        for(int[] arr: result){
            Arrays.fill(arr,-1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j]=matrix[j][i];
                
            }
        }
        return result;
    }
}