class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        s=0
        for i in range(k):
            s+=nums[i]
        ms=s
        i=k
        j=0
        while i<len(nums):
            s-=nums[j]
            s+=nums[i]
            ms=max(ms,s)
            i+=1
            j+=1
        return ms/k
        