class Solution:
    def numDecodings(self, s: str) -> int:
        dp=[-1 for i in range(len(s)+1)]
        return self.solve(s,0,dp)
    def solve(self,string,i,dp):
        if i>=len(string):
            return 1
        else:
            if string[i]=='0':
                return 0
            if dp[i]!=-1:
                return dp[i]
            l=r=0
            l=self.solve(string,i+1,dp)
            if i<len(string)-1:
                
                num=int(string[i:i+2])
                if num>=10 and num<=26:
                    r=self.solve(string,i+2,dp)
            dp[i]=l+r
            return dp[i]
        '''def solve(s,i,DP):
            if i>=len(s):
                return 1
            else:
                if s[i]=='0':
                    return 0
                if DP[i]!=-1:
                    return DP[i]
                
                a=b=0
                a=solve(s,i+1,DP)
                if i<len(s)-1:
                    num=int(s[i:i+2])
                    if num<=26:
                        b=solve(s,i+2,DP)
                DP[i]= a+b
                return DP[i]
        DP=[-1 for i in range(len(s)+1)]
        return solve(s,0,DP)'''
    