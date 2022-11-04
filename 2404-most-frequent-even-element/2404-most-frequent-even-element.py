class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        d={}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=1
            else:
                d[nums[i]]+=1
        max_heap=[]
        for n,freq in d.items():
            if n%2==0:
                heappush(max_heap,(-freq,n))
        if len(max_heap)==0:
            return -1
        k,l=heappop(max_heap)
        return l