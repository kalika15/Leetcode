class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        i=0 
        j=1
        c=0
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                c=-1
                break
                
        l=0
        for i in range(len(nums)-1):
            if nums[i]<nums[i+1]:
                l=-1
                break
        if c==0 or l==0:
            return True
        return False