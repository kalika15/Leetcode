class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        ws=0
        c=0
        l=0
        ans=0
        for we in range(len(nums)):
            if nums[we]%2==1:
                l+=1
                c=0
            while l==k:
                c+=1
                if nums[ws]%2==1:
                    l-=1
                ws+=1
            ans+=c
        return ans