class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack=[]
        m=0
        stack.append(-1)
        for i in range(len(s)):
            if s[i]=='(':
                stack.append(i)
            else:
                stack.pop()
                if len(stack)==0:
                    stack.append(i)
                else:
                    m=max(m,i-stack[-1])
                    
        return m