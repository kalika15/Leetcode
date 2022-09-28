class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        s=nums1+nums2
        s.sort()
        i=0
        j=len(s)-1
        k=0
        if len(s)%2!=0:
            mid=(i+j)//2
            k=s[mid]
        else:
            
            mid=(i+j)//2
            print(mid+1)
            k=(s[mid+1]+s[mid])/2
        return round(k,5)
            
        