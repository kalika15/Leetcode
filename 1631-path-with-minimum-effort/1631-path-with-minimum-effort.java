class Pair{
    int effort;
    int row;
    int col;
    public Pair(int effort, int row, int col){
        this.effort=effort;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> Integer.compare(x.effort,y.effort));
        int[][] dist=new int[m][n];
        for(int[] dis: dist){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int effort=pair.effort;
            int row=pair.row;
            int col=pair.col;
            if(row==m-1 && col==n-1){
                return effort;
            }
            for(int[] direction: directions){
                int new_row=row+direction[0];
                int new_col=col+direction[1];
                if(new_row>=0 && new_row<m && new_col>=0 && new_col<n){
                    int new_effort=Math.max(effort,Math.abs(heights[row][col]-heights[new_row][new_col]));
                    if(new_effort< dist[new_row][new_col]){
                        dist[new_row][new_col]=new_effort;
                        pq.offer(new Pair(new_effort,new_row,new_col));
                    }
                }
            }
        }
        return 0;
    }
}