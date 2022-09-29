class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        stack=[]
        c=len(nums)-k
        for i in range(len(nums)):
            curr=nums[i]
            while len(stack)!=0 and stack[-1]>curr and c!=0:
                stack.pop()
                c-=1
            stack.append(curr)
        return stack[:k]
            
        