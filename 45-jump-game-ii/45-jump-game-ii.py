class Solution:
    def jump(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[0]*n
        for i in range(n-2,-1,-1):
            mn=2**63-1
            for j in range(i+1,min(n,nums[i]+i+1)):
                mn=min(mn,dp[j])
            dp[i]=1+mn
        return dp[0]