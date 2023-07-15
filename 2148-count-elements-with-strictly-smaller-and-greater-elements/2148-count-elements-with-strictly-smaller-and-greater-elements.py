class Solution:
    def countElements(self, nums: List[int]) -> int:
        nums.sort()
        stack=[]
        count=0
        stack.append(nums[0])
        for i in range(1,len(nums)-1):
            
            if stack[-1]<nums[i]:
                stack.append(nums[i])
            else:
                continue
            for j in range(i,len(nums)):
                if stack[-1]<nums[j]:
                    count+=1
                    break
            print(stack)
            stack.pop()
        return count 