class Solution:
    def canJump(self, nums: List[int]) -> bool:
        pos=len(nums)-1
        for i in reversed(range(len(nums)-1)):
            if i+nums[i]>=pos:
                pos=i
        if pos==0:
            return True
        return False
        
                