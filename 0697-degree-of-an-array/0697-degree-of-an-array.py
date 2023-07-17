class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        if len(nums)==1 or len(list(set(nums)))==len(nums):
            return 1
        d={}
        ans=0
        for i in range(len(nums)):
            if nums[i] in d:
                d[nums[i]]+=1
                ans=max(ans,d[nums[i]])
            else:
                d[nums[i]]=1
        ele=[]
        for i,j in d.items():
            if j==ans:
                ele.append(i)
        result=len(nums)
        print(ele)
        for i in range(len(ele)):
            num=ele[i]
            arr=nums
            left=0
            right=0
            for j in range(len(arr)):
                if arr[j]==num:
                    arr[j]==-1
                    left=j
                    break
            for j in range(len(arr)-1,-1,-1):
                if arr[j]==num:
                    arr[j]=-1
                    right=j
                    break
            print(arr[left:right+1])
            result=min(result,len(nums[left:right+1]))


        
        return result
             
        
        
