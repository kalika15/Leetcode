from typing import List

class Solution:
    def finLength(self, N : int, color : List[int], radius : List[int]) -> int:
        # code here
        ans=[]
        
        for i in range(N):
            if len(ans)==0:
                ans.append([color[i],radius[i]])
            elif ans[-1][0]==color[i] and ans[-1][1]==radius[i]:
                ans.pop()
            else:
                ans.append([color[i],radius[i]])
        return len(ans)
        



#{ 
 # Driver Code Starts
class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        N = int(input())
        
        
        color=IntArray().Input(N)
        
        
        radius=IntArray().Input(N)
        
        obj = Solution()
        res = obj.finLength(N, color, radius)
        
        print(res)
        

# } Driver Code Ends