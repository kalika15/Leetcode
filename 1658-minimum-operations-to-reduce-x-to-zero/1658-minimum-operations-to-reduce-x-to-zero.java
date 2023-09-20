class Solution {
    public int minOperations(int[] nums, int x) {
        int target=Arrays.stream(nums).sum()-x;
        if(target<0) return -1;
        if(target==0) return nums.length;

        int operation=-1;
        int windowSum=0;
        int start=0;
        int end=0;

        while(end<nums.length){
            windowSum+=nums[end];
            while(windowSum>target){
                windowSum-=nums[start];
                start++;
            }
            if(windowSum==target){
                operation=Math.max(operation,end-start+1);
            }
            end++;
        }
        if(operation==-1)return -1;
        return nums.length-operation;
    }
}