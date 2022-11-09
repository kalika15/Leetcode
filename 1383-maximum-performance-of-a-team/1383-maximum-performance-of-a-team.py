class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        eng=[]
        for i in range(n):
            eng.append([efficiency[i],speed[i]])
        eng=sorted(eng,reverse=True)
        min_heap=[]
        ans=0
        l=0
        
        for eff,spd in eng:
            if k==len(min_heap):
                l-=heappop(min_heap)
            l+=spd
            heappush(min_heap,spd)
            ans=max(ans,eff*l)
        return ans%(10**9+7)
            
        