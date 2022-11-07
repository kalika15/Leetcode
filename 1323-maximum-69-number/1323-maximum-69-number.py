class Solution:
    def maximum69Number (self, num: int) -> int:
        s=str(num)
        i=0
        ans=""
        while i<=len(s)-1:
            if s[i]=='9':
                ans+=s[i]
                i+=1
            else:
                ans+="9"
                ans+=s[i+1:]
                break
        return ans