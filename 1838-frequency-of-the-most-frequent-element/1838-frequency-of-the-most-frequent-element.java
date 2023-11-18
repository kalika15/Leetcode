class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int sum=0;
        int max=0;
        for(i=0; i<nums.length; i++){
            sum+=nums[i];
            while((i-j+1)*nums[i]-sum>k){
                sum-=nums[j];
                j++;
            }
            max=Math.max(max, i-j+1);
        }
        return max;
    }
}