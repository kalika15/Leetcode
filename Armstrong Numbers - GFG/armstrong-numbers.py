#User function Template for python3

#User function Template for python3
class Solution:
    def armstrongNumber (self, n):
        # code here 
        arr=[]
        for i in str(n):
            arr.append(int(i))
        
        s=0
            
        for num in arr:
            s+=num**3
        if(s==n):
            return "Yes"
        else:
            return "No"
        

#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        n = input()
        n=int(n)
        ob = Solution()
        print(ob.armstrongNumber(n))
# } Driver Code Ends