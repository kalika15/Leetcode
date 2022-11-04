class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        d={}
        c=0
        n=len(nums)
        for i in range(len(nums)):
            if nums[i]-i not in d:
                d[nums[i]-i]=1
            else:
                c+=d[nums[i]-i]
                d[nums[i]-i]+=1
        return (n*(n-1))//2-c