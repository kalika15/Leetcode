class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=1;
        int m=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                n=m+1;
            }
            else if(nums[i]<nums[i-1]){
                m=n+1;
            }
        }
        return Math.max(n,m);

    }
}