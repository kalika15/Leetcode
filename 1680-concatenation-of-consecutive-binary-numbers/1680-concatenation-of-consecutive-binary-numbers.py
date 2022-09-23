class Solution:
    def concatenatedBinary(self, n: int) -> int:
        k=""
        i=1
        while i!=n+1:
            k+=bin(i)[2:]
            i+=1
        return (int(k,2))%(10**9+7)
        
        