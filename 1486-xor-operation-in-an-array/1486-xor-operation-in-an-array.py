class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        a=[]
        for i in range(0,n):
            a.append(start+2*i)
        k=0
        for i in a:
            k^=i
        return k