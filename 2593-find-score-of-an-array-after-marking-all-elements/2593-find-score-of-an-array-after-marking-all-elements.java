
class Solution {
    public long findScore(int[] nums) {
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<int[]> min_heap=new PriorityQueue<>((a,b)->
        (a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            min_heap.add(new int[]{nums[i],i});
        }
        while(!min_heap.isEmpty()){
            int[] curr=min_heap.poll();
            int curr_ele=curr[0];
            int curr_idx=curr[1];
            if(!visited.contains(curr_idx)){
                visited.add(curr_idx);
                ans+=curr_ele;
                if((curr_idx+1)>=0) visited.add(curr_idx+1);
                if((curr_idx-1)>=0) visited.add(curr_idx-1);
            }
        }
        return ans;
    }

}