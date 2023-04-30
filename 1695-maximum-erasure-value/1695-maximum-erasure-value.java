class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        int ans=0;
        int s=0;
        int l=0;
        for(int i: nums){
            while(hashSet.contains(i)){
                s-=nums[l];
                hashSet.remove(nums[l]);
                l++;
            }
            hashSet.add(i);
            s+=i;
            ans=Math.max(ans,s);
        }
        return ans;
    }
}