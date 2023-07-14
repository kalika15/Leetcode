class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        s=""
        a=min(nums1)
        b=min(nums2)
        s+=str(a)
        s+=str(b)
        ans=float('inf')
        for i in nums1:
            if i in nums2:
                ans=min(ans,i)
        s1=s[::-1]
        return min(int(s),ans,int(s1))