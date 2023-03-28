class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        ans=0
        l=nums[0]
        for i in range(1,len(nums)-1):
            if (l>nums[i] and nums[i]<nums[i+1]) or (l<nums[i] and nums[i]>nums[i+1]):
                ans+=1
                l=nums[i]
        return ans