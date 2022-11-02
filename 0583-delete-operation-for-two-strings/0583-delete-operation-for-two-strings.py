class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        
        return self.lcs(word1,word2,len(word1),len(word2))
    def lcs(self,s1,s2,n,m):
        dp=[[0 for i in range(m+1)]for j in range(n+1)]
        
        for i in range(n+1):
            for j in range(m+1):
                if i==0 :
                    dp[i][j]=j
                elif j==0 :
                    dp[i][j]=i

                elif s1[i-1]!=s2[j-1]:
                    dp[i][j]=1+min(dp[i-1][j],dp[i][j-1])
                else:
                    dp[i][j]=dp[i-1][j-1]
        return dp[n][m]