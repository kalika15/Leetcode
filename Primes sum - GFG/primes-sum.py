import math
#User function Template for python3
class Solution:
    def isSumOfTwo (self, N):
        # code here 
        if N<=2:
            return "No"
        elif N%2==0:
            return "Yes"
        else:
            N=N-2 
            for i in range(2,int(math.sqrt(N))+1):
                if not N%i:
                    return "No"
            return "Yes"


#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
        
        ob = Solution()
        print(ob.isSumOfTwo(N))
# } Driver Code Ends