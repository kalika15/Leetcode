class Solution {
    int[][] directions=new int[][] {{-2,-1},{-2,1},{-1,2},{2,1},{-1,-2},{1,-2},{2,-1},{1,2}};
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0]!=0) return false;
        dfs(0,0,grid,0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1) return false;
            }
        }
        return true;
    }
    public void dfs(int row,int col,int[][] grid,int number){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return;
        }
         if(grid[row][col]==number){
             grid[row][col]=-1;
             for(int[] direction:directions){
                 dfs(row+direction[0],col+direction[1],grid,number+1);
             }
         }
    }
}