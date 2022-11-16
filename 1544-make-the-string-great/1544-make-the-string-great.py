class Solution:
    def makeGood(self, s: str) -> str:
        stack=[]
        for i in range(len(s)):
            curr=s[i]
            if len(stack)!=0 and stack[-1]==curr.swapcase():
                stack.pop()
            else:
                stack.append(curr)
        return "".join(stack)