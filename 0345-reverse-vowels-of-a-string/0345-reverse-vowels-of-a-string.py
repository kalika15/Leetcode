class Solution:
    def reverseVowels(self, s: str) -> str:
        v=['a','e','i','o','u','A','E','I','O','U']
        s=list(s)
        i=0
        j=len(s)-1
        while i<j:
            
            if s[i] in v:
                if s[j] in v:
                    s[i],s[j]=s[j],s[i]
                    i+=1
                    j-=1
                else:
                    j-=1
                
            
            elif s[j]  in v :
                if s[i] in v:
                    s[i],s[j]=s[j],s[i]
                    i+=1
                    j-=1
                else:
                    i+=1
            else:
                i+=1
                j-=1
            
        return ''.join(k for k in s)
    