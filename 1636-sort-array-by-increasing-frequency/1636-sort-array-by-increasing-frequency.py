class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        d={}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=1
            else:
                d[nums[i]]+=1
        max_heap=[]
        for i,freq in d.items():
            heappush(max_heap,(-freq,i))

        ans=[]
        for i in range(len(max_heap)):
            f1,n1=heappop(max_heap)
            while f1!=0:
                ans.append(n1)
                f1+=1
        return ans[::-1]