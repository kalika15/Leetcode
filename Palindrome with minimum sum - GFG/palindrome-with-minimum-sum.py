import math
class Solution:
    def minimumSum(self, s : str) -> int:
        
        i , j = 0 , len(s)-1
        
        stack = []
        
        c     = 0
        
        while i < j:
                
            if s[i] == s[j] and s[i]!="?":
                
                if stack:
                    
                    c+=2*(abs(ord(stack[-1])-ord(s[i])))
                    
            elif s[i] != s[j] and s[i]!="?" and s[j]!="?":
                
                return -1
                
            elif s[i] != s[j]:
                
                if s[i]!="?":
                    
                    if stack:
                        
                        c+=2*(abs(ord(stack[-1])-ord(s[i])))
                        
                else:
                    
                    if stack:
                        
                        c+=2*(abs(ord(stack[-1])-ord(s[j])))
                        
            if s[i] !="?":
                
                stack.append(s[i])
                
            elif s[j]!="?":
                
                stack.append(s[j])
                        
            i+=1
            j-=1
                 
        return c


#{ 
 # Driver Code Starts
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        s = (input())
        
        obj = Solution()
        res = obj.minimumSum(s)
        
        print(res)
        

# } Driver Code Ends