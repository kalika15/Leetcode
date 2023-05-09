class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null && matrix.length==0){
            return result;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0;
        int right=cols-1;
        int top=0;
        int bottom=rows-1;
        while(left<=right && top<=bottom){
            for(int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top+=1;
            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right-=1;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}