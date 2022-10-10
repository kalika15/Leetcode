class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans=''
        for i in range(len(s)):
            l=i
            r=i+1
            while (l>=0 and r<len(s)and s[l]==s[r]):
                if r-l+1>len(ans):
                    ans=s[l:r+1]
                l-=1
                r+=1
            l=i
            r=i
            while (l>=0 and r<len(s) and s[l]==s[r]):
                if r-l+1>len(ans):
                    ans=s[l:r+1]
                l-=1
                r+=1
        return ans
        
        