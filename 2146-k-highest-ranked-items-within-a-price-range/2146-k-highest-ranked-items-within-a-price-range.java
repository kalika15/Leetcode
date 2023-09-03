class Pair{
    int row,col,dis;
    public Pair(int row,int col,int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int[][] direction=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        List<List<Integer>> result=new ArrayList<>();

        int n=grid.length;
        int m=grid[0].length;

        PriorityQueue<Pair> heap=new PriorityQueue<>((a,b)->{
            if(a.dis!=b.dis){
                return b.dis-a.dis;
            }
            else{
                if(grid[b.row][b.col]!=grid[a.row][a.col]){
                    return grid[b.row][b.col]-grid[a.row][a.col];
                }
                else{
                    if(a.row!=b.row) return b.row-a.row;
                    else return b.col-a.col;
                }
            }
        });

        LinkedList<Pair> q=new LinkedList<>();
        q.add(new Pair(start[0],start[1],0));

        boolean[][] visited=new boolean[n][m];

        visited[start[0]][start[1]]=true;

        while(!q.isEmpty()){
            Pair pair=q.removeFirst();
            int price=grid[pair.row][pair.col];
            if(price!=1 && pricing[0]<=price && pricing[1]>=price){
                heap.add(pair);
                if(heap.size()>k){
                    heap.remove();
                }
            }
            for(int i=0; i<4; i++){
                int x=direction[i][0]+pair.row;
                int y=direction[i][1]+pair.col;
                if(x<0 || y<0 || x==n || y==m || visited[x][y] || grid[x][y]==0){
                    continue;
                }
                visited[x][y]=true;
                q.add(new Pair(x,y,pair.dis+1));
            }
        }
        while(heap.size()>0){
            Pair pair=heap.poll();
            List<Integer> corrdinator=new LinkedList<>();
            corrdinator.add(pair.row);
            corrdinator.add(pair.col);
            result.add(corrdinator);
        }
        Collections.reverse(result);
        return result;
    }
}