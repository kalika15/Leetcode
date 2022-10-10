class Solution:
    def simplifyPath(self, path: str) -> str:
        stack=[]
        f=path.split("/")
        for i in f:
            if  i=='..':
                if len(stack)!=0:
                    stack.pop()
            elif i=="" or i=='.':
                continue
            else:
                stack.append(i)
        ans='/'+'/'.join(stack)
                
        return ans
    
            
        