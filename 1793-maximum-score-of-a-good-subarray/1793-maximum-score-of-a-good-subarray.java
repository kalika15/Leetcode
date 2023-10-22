class Solution {
    public int maximumScore(int[] nums, int k) {
        int res=Integer.MIN_VALUE;
        int n=nums.length;
        if(n==1) return nums[0];
        int min=nums[k];
        int i=k;
        int j=k;
        // int n=nums.length;
        while(i>0 || j<n-1){
            if(i==0) j++;
            else if(j==n-1) i--;
            else if(nums[i-1]<nums[j+1]) j++;
            else i--;
            min=Math.min(min, Math.min(nums[i], nums[j]));
            res=Math.max(res, min* (j-i+1));
        }
        return res;
    }
}