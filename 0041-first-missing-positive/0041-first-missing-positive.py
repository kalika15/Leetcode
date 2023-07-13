class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums=set(nums)
        si=1
        while nums:
            if si not in nums:
                return si
            si+=1