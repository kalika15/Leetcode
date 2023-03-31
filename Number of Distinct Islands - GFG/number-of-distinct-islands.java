//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] directions=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<String>> hashSet= new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    List<String> pattern=new ArrayList<>();
                    dfs(i,j,grid,i,j,pattern);
                    hashSet.add(pattern);
                }
            }
        }
        return hashSet.size();
    }
    void dfs(int row,int col,int[][] grid, int src_row,int src_col,List<String> pattern){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1){
            return;
        }
        grid[row][col]=2;
        pattern.add(Integer.toString(src_row-row)+Integer.toString(src_col-col));
        for(int[] direction:directions){
            int new_row=row+direction[0];
            int new_col=col+direction[1];
            dfs(new_row,new_col,grid,src_row,src_col,pattern);
        }
    }
}
