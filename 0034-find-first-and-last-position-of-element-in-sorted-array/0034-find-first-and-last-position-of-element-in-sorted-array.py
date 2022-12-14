class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if target not in nums:
            return [-1,-1]
        start=nums.index(target)
        c=nums.count(target)
        return [start,start+c-1]