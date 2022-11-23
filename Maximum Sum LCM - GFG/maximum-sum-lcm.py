#User function Template for python3
class Solution:

    def maxSumLCM (self, n):

        # code here

        h=1

        a=set()

        while h*h<=n:

            if n%h==0:

                a.add(h)

                a.add(n//h)

            h+=1

        return sum(a)

#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        n = int(input())
        
        ob = Solution()
        print(ob.maxSumLCM(n))
# } Driver Code Ends