class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        ans=[]
        if k==1:
            return (i for i in range(1,len(nums)-1))
        l=[]
        c=1
        for i in range(1,len(nums)):
            if nums[i-1]>=nums[i]:
                c+=1
            else:
                c=1
            if c>=k:
                l.append(i)
        r=[]
        for i in range(1,len(nums))[::-1]:
            if nums[i-1]<=nums[i]:
                c+=1
            else:
                c=1
            if c>=k:
                r.append(i-1)
        l=set(l)
        r=set(r)
        for i in range(k,len(nums)-k):
            if i-1 in l and i+1 in r:
                ans.append(i)
        return ans
        