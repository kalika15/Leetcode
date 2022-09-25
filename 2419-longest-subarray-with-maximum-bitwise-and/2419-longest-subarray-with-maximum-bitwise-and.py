class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        d=dict(Counter(nums))
        m=max(d.keys())
        '''k=list(d.values())[list(d.keys()).index(m)]
        if k%2==0 or k==1:
            return k
        else:
            return k-1'''
        l=0
        c=0
        for i in nums:
            if m==i:
                c+=1
            else:
                c=0
            l=max(c,l)
        return l
        
                