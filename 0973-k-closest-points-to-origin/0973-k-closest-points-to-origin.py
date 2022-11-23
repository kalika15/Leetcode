
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_heap=[]
        for i in range(len(points)):
            m=(points[i][0]**2)+(points[i][1]**2)
            heappush(min_heap,(m,points[i]))
        ans=[]
        while k>0:
            l=heappop(min_heap)
            ans.append(l[1])
            k-=1
        return ans
            
        