class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack=[]
        for i in range(len(s)):
            f=0
            while len(stack)!=0 and stack[-1]==s[i]:
                stack.pop()
                f=1
                continue
            if f==1:
                continue
                
            stack.append(s[i])
            
        return ''.join(stack)
            