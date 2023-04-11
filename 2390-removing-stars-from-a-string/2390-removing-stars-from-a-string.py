class Solution:
    def removeStars(self, s: str) -> str:
        stack=[]
        for i in range(len(s)):
            if len(stack)>0 and s[i]=='*':
                stack.pop()
                continue
            else:
                stack.append(s[i])
        ans=""
        for i in range(len(stack)):
            ans+=stack[i]
        return ans
            
                
                
        