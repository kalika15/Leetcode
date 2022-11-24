class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        min_heap=[]
        for i in range(len(mat)):
            c=0
            for j in range(len(mat[0])):
                if mat[i][j]==1:
                    c+=1
            heappush(min_heap,(c,i))
        ans=[]
        while k>0:
            m=heappop(min_heap)
            ans.append(m[1])
            k-=1
        return ans