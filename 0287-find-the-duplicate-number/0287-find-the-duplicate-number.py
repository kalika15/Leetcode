class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        d={}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=1
            else:
                return nums[i]
                