class Solution{
    public int longestConsecutive(int[] nums) {
        int max=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int num: set){
            if(!set.contains(num-1)){
                int curr=num;
                int count=1;
                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }
                max=Integer.max(max,count);
            }
        }
        return max;
    }
}
