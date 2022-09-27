class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack=nums[::-1]
        ans=[0]*len(nums)
        for i in range(len(nums)-1,-1,-1):
            curr=nums[i]
            while len(stack)!=0 and stack[-1]<=curr:
                stack.pop()
            if len(stack)!=0:
                ans[i]=stack[-1]
            else:
                ans[i]=-1
            stack.append(curr)
        return ans