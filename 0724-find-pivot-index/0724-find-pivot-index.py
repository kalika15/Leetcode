class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            l=sum(nums[:i])
            r=sum(nums[i+1:])
            if l==r:
                return i
        return -1