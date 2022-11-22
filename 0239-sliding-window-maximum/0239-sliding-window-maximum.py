class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        max_heap=[]
        temp=[]
        for i in range(k):
            heappush(max_heap,(-nums[i],i))
        temp.append(-max_heap[0][0])
        
        j=k
        while j<len(nums):
            heappush(max_heap,(-nums[j],j))
            while max_heap[0][1]<j-k+1:
                heappop(max_heap)
            temp.append(-max_heap[0][0])
            j+=1
        return temp
       