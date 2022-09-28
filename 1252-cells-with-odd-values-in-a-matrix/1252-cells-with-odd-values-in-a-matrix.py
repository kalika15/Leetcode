class Solution:
    def oddCells(self, m: int, n: int, indices: List[List[int]]) -> int:
        arr=[[0 for i in range(n)]for i in range(m)]
        for i in indices:
            r=i[0]
            c=i[1]
            for j in range(n):
                arr[r][j]+=1
            for l in range(m):
                arr[l][c]+=1
        c=0
        for i in range(len(arr)):
            for j in range(len(arr[i])):
                if arr[i][j]%2!=0:
                    c+=1
        return c