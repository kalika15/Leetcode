class Solution:
    def smallestSubsequence(self, s: str) -> str:
        d=Counter(s)
            
        stack=[]
        v=set()
        for i in range(len(s)):
            d[s[i]]-=1
            if s[i] not in v:
                while len(stack)!=0 and stack[-1]>s[i] and d[stack[-1]]:
                    v.remove(stack[-1])
                    stack.pop()
                v.add(s[i])
                stack.append(s[i])
        return "".join(stack)
                
                