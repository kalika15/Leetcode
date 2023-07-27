class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        heap=[]
        for i in range(len(arr)):
            heappush(heap,[-arr[i],i])
        ans=heappop(heap)
        return ans[1]