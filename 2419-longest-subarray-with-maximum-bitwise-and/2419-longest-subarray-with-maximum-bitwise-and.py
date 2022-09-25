class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        m=max(nums)
        l=0
        c=0
        for i in nums:
            if m==i:
                c+=1
            else:
                c=0
            l=max(c,l)
        return l
        
                