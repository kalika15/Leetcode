class Solution:
    def countSubstrings(self, s: str) -> int:
        dp=[[-1 for i in range(len(s))]for i in range(len(s))]
        c=0
        for g in range(0,len(s)):
            i=0
            j=g
            while j<len(s):
                if g==0:
                    dp[i][j]=1
                    c+=1
                elif g==1:
                    if s[i]==s[j]:
                        dp[i][j]=1
                        c+=1
                    else:
                        dp[i][j]=0
                else:
                    if s[i]==s[j] and dp[i+1][j-1]==1:
                        dp[i][j]=1
                        c+=1
                    else:
                        dp[i][j]=0
                i+=1
                j+=1
                    
        return c
                    