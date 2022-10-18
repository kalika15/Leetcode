class Solution:
    def countAndSay(self, n: int) -> str:
        s="1"
        for j in range(n-1):
            c=1
            temp=""
            for i in range(1,len(s)):
                if s[i]==s[i-1]:
                    c+=1
                else:
                    temp+=str(c)+s[i-1]
                    c=1
            temp+=str(c)+s[-1]
            s=temp
        return s
        