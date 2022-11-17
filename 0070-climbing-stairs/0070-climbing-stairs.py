class Solution:
    def climbStairs(self, n: int) -> int:
        if n==1:
            return 1
        if n==2:
            return 2
        p1=1
        p2=1
        for i in range(2,n+1):
            c=p1+p2
            p1=p2
            p2=c
        return p2
            
            
        
            
        
        