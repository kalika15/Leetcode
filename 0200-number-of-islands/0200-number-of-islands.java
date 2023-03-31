class Solution {
    int[][] directions=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count+=1;
                }
            }
                
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        for(int[] direction:directions){
            int new_x=direction[0]+i;
            int new_y=direction[1]+j;
            dfs(new_x,new_y,grid);
        }
    }
}