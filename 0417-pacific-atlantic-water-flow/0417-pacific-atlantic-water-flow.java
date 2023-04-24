class Solution {
    int[][] directions =new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    private void dfs(int row,int col, int prev, int[][] height,boolean[][] ocean){
        if(row<0 || row>=height.length || col<0 || col>=height[0].length ){
            return;
        }
        if(ocean[row][col] || height[row][col]< prev) return;
        ocean[row][col]=true;
        for(int[] direction: directions){
            int new_row=row+direction[0];
            int new_col=col+direction[1];
            dfs(new_row,new_col,height[row][col],height,ocean);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];

        for(int i=0;i<col;i++){
            dfs(0, i, Integer.MIN_VALUE, heights,pacific);
            dfs(row-1, i, Integer.MIN_VALUE, heights,atlantic);
        }

        for(int i=0;i<row;i++){
            dfs(i, 0, Integer.MIN_VALUE, heights,pacific);
            dfs(i, col-1, Integer.MIN_VALUE, heights,atlantic);
        }

        for(int i=0;i<row ;i++){
            for(int j=0; j<col ;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;

    }
}