class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        s=0
        for i in range(len(nums)):
            if i%2==0:
                s+=nums[i]
        return s