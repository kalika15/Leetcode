class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d=dict(Counter(nums))
        l=d.keys()
        l=sorted(l)
        c=0
        for i in range(len(l)):
            if l[i]-l[i-1]==1:
                c=max(c,d[l[i]]+d[l[i-1]])
        return c