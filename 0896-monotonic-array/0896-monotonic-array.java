class Solution {
    public boolean isMonotonic(int[] nums) {
        int i=0;
        int c=0;
        for(i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                c--;
                break;
            }
        }
        int l=0;
        for(i=0; i<nums.length-1 ; i++){
            if(nums[i]<nums[i+1]){
                l--;
                break;
            }
        }
        if(c==0 || l==0){
            return true;
        }
        return false;
    }
}