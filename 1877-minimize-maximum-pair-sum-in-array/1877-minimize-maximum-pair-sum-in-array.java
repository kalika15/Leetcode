class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        // for(int num: nums){
        //     System.out.print(num);
        // }
        int left=0;
        int right=nums.length-1;
        int max=0;
        int sum=0;
        while(left<right){
            sum=nums[left]+nums[right];
            max=Integer.max(max, sum);
            left++;
            right--;
        }
        return max;
    }
}