class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        return self.solve(s,p,len(s),len(p))
    '''def solve(self,s,p,n,m):
        if n==0 and m==0:
            return True
        elif n==0 and set(p[:m])==set("*"):          
            return True
        elif n==0:
            return False
        elif m==0:
            return False
        elif s[n-1]==p[m-1] or p[m-1]=="?":
            return self.solve(s,p,n-1,m-1)
        elif p[m-1]=='*':
            flag=False
            for i in range(n+1):
                flag=flag or self.solve(s,p,n-i,m-1)
                if flag==True:
                    return flag
            return flag
        else:
            return False
                '''
    def solve(self,s,p,n,m):
        dp=[[0 for i in range(m+1)]for j in range(n+1)]
        
        for i in range(n+1):
            for j in range(m+1):
                if i==0 and j==0:
                    dp[i][j]=True
                elif i==0 and p[j-1]=="*":
                    dp[i][j]=dp[i][j-1]
                elif i==0:
                    dp[0][j]=False
                elif j==0:
                    dp[i][0]=False
                elif s[i-1]==p[j-1] or p[j-1]=="?":
                    dp[i][j]=dp[i-1][j-1]
                elif p[j-1]=="*":
                    dp[i][j]=dp[i-1][j] or dp[i][j-1]
                else:
                    dp[i][j]=False
        return dp[n][m]
        
            