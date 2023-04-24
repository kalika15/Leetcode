class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxheap=[]
        for i in stones:
            heappush(maxheap,-i)
        while len(maxheap)>=2:
            if len(maxheap)>=2:
                a=heappop(maxheap)
                b=heappop(maxheap)
                if a==b:
                    continue
                else:
                    heappush(maxheap,-abs(abs(a)-abs(b)))
        print(maxheap)     
        
        if len(maxheap)==0:
            return 0
        return -maxheap[-1]