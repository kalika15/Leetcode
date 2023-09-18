class Pair{
    int count, idx;
    public Pair(int count, int idx){
        this.count=count;
        this.idx=idx;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.count!=b.count) return Integer.compare(a.count,b.count);
            else{
                return Integer.compare(a.idx,b.idx);
            }
        });
        for(int i=0; i<mat.length; i++){
            int c=0;
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]==1) c++;
            }
            pq.add(new Pair(c,i));
        }
        int[] ans=new int[k];
        Arrays.fill(ans,-1);
        int i=0;
        while(k>0){
            Pair a=pq.poll();
            ans[i]=a.idx;
            k--;
            i++;
        }
        return ans;
    }
}