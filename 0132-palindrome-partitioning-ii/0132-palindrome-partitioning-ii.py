import math
class Solution:
    def minCut(self, s: str) -> int:
        def isP(a):
            if a==a[::-1]:
                return True
            else:
                return False
        def solve(s,i,j,dp):
            if i>=j or isP(s[i:j+1]): 
                return 0
            if dp[i][j]!=-1:
                return dp[i][j]
            min_step=math.inf
            for k in range(i,j):
                if(isP(s[i:k+1])):
                    temp=1+solve(s,k+1,j,dp)
                    min_step=min(min_step,temp)
            dp[i][j]=min_step        
            return dp[i][j]
        dp=[[-1 for i in range(len(s)+1)]for j in range(len(s)+1)]
        ans=solve(s,0,len(s)-1,dp)
        return ans