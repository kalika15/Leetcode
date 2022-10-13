class Solution:
    def freqAlphabets(self, s: str) -> str:
        ans=""
        i=len(s)-1
        while i>=0:
            if s[i]=='#':
                ans+=chr(int(s[i-2:i])+96)
                i-=2
            else:
                ans+=chr(int(s[i])+96)
            i-=1
        return ans[::-1]