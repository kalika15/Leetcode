class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        ans=[]
        t=[0]
        for i in arr:
            t.append(t[-1]^i)
        for i in queries:
            k=i[0]
            m=i[1]
            ans.append(t[m+1]^t[k])
        return ans