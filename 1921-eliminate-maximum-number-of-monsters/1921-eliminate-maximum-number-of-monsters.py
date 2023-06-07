class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        min_heap=[]
        for i in range(len(dist)):
            heappush(min_heap,(dist[i]+speed[i]-1)//speed[i])
        c=0
        while(min_heap):
            t=heappop(min_heap)
            if((t-c)<=0):
                return c
            c+=1
        return c

