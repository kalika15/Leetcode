class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d={}
        for i in nums:
            d[i]=d.get(i,0)+1
        max_heap=[]
        for i,freq in d.items():
            heappush(max_heap,(-freq,i))
        ans=[]
        while max_heap:
            curr_freq,curr_item=heappop(max_heap)
            curr_freq=-(curr_freq)
            while k!=0:
                ans.append(curr_item)
                k-=1
                break
        return ans