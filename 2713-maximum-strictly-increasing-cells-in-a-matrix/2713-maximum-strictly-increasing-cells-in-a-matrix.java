class Solution {

    public int maxIncreasingCells(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer,List<int[]>> map=new TreeMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val=mat[i][j];
                if(!map.containsKey(val)){
                    map.put(val,new ArrayList<int[]>());
                }
                map.get(val).add(new int[]{i,j});
            }
        }
        int[][] dp=new int[n][m];
        int[] res=new int[n+m];
        for(int key:map.keySet()){
            for(int[] pos:map.get(key)){
                int row=pos[0];
                int col=pos[1];
                dp[row][col]=Math.max(res[row],res[n+col])+1;
            }
            for(int[] pos: map.get(key)){
                int row=pos[0];
                int col=pos[1];
                res[n+col]=Math.max(res[n+col],dp[row][col]);
                res[row]=Math.max(res[row],dp[row][col]);
            }
        }
        int result=0;
        for(int i: res){
            result=Math.max(result,i);
        }
        return result;
    }
}