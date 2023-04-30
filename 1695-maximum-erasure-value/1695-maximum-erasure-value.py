class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        hashSet=set()
        ans=s=l=0
        for i in nums:
            while i in hashSet:
                s-=nums[l]
                hashSet.remove(nums[l])
                l+=1
            hashSet.add(i)
            s+=i
            ans=max(ans,s)
        return ans

        