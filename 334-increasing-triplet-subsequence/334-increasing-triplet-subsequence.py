class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        if len(set(nums))<3 or len(nums)<3:
            return False

        i=0
        j=1
        k=2
        while k<len(nums) or j<len(nums)-1:
            if nums[j]<=nums[i]:
                i=i+1
                j=i+1
                k=j+1
            else:
                if nums[k]>nums[j]:
                    return True
                else:
                    k=k+1
                    if k==len(nums):
                        j=j+1
                        k=j+1
        return False