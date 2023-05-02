class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        n=len(queries)
        m=len(nums[0])
        result=[]
        l=0
        while(n>l):
            kth=queries[l][0]
            trim=queries[l][1]
            min_heap=[]
            for i in range(len(nums)):
                s=nums[i]
                temp=s[m-trim:m]
                heappush(min_heap,[int(temp),i])
            k=1
            while(len(min_heap)>0):
                a=heappop(min_heap)
                if(k==kth):
                    result.append(a[1])
                    break
                k+=1
            l+=1
        return result
                
        