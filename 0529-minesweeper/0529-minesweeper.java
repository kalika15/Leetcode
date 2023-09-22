class Solution {
    int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},{0, -1}, {0, 1},{1, -1}, {1, 0}, {1, 1}};
    int m,n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m=board.length;
        n=board[0].length;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
        }
        else{
            int mines=countMines(board, click);
            if(mines>0){
                board[click[0]][click[1]]=(char)(mines+'0');
            }
            else{
                board[click[0]][click[1]]='B';
                List<int[]> neighbors=getUnrevealed(board, click);
                for(int[] coordinate: neighbors){
                    updateBoard(board, coordinate);
                }
            }
        }
        return board;
    }

    public int countMines(char[][] board, int[] click){
        int mines=0;
        for(int[] delta: deltas){
            int x= click[0]+ delta[0];
            int y= click[1]+ delta[1];

            if(x>=0 && x<m && y>=0 && y<n){
                if(board[x][y]=='M') mines++;
            }
            
        }
        return mines;
    }

    public List<int[]> getUnrevealed(char[][] board, int[] click){
        // int mines=0;
        List<int[]> neighbors=new ArrayList<>();
        for(int[] delta: deltas){
            int x= click[0]+ delta[0];
            int y= click[1]+ delta[1];

            if(x>=0 && x<m && y>=0 && y<n){
                if(board[x][y]=='E'){
                    neighbors.add(new int[]{x,y});
                }
            }
            
        }
        return neighbors;
    }

}