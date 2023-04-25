class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][] =new char[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        nqueen(0,new HashSet<>(),new HashSet<>(),new HashSet<>(),board);
        return ans;

    }
    public void nqueen(int row, Set<Integer> cols,Set<Integer> dig,Set<Integer> antidig,char[][] board){
        if (row == board.length){
            ans.add(arrange(board));
            return;
        }
        for (int col=0;col<board.length;col++){
            int curr_dig=row-col;
            int curr_antidig=row+col;
            if (cols.contains(col) || dig.contains(curr_dig) || antidig.contains(curr_antidig))continue;
            cols.add(col);
            dig.add(curr_dig);
            antidig.add(curr_antidig);
            board[row][col]='Q';
            nqueen(row+1,cols,dig,antidig,board);
            cols.remove(col);
            dig.remove(curr_dig);
            antidig.remove(curr_antidig);
            board[row][col]='.';

            
        }
    }
    public List<String>  arrange(char[][] board){
        List<String> an=new ArrayList<>();
        for (int i=0;i<board.length;i++){
            StringBuilder s=new StringBuilder();
            for(int j=0;j<board.length;j++){
                s.append(board[i][j]);
            }
            an.add(s.toString());
        }
        return an;
    }
}