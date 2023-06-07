class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> min_heap=new PriorityQueue<>();
        for(int i=0; i<dist.length; i++){
            min_heap.offer((dist[i]+speed[i]-1)/speed[i]);
        }
        int count=0;
        while(!min_heap.isEmpty()){
            int t=min_heap.poll();
            if((t-count)<=0) return count;
            count++;
        }
        return count;
    }
}