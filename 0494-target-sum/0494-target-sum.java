class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        count=0;
        solve(0,0,nums,target);
        return count;
    }


    public void solve(int i,int v,int[] nums,int target){
        if(i==nums.length){
            if(v==target) count++;
        }
        else{
            solve(i+1,v+nums[i],nums,target);
            solve(i+1,v-nums[i],nums,target);
        }

    }
    
}