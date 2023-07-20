#User function Template for python3
class Solution:
	def setBits(self, N):
		# code here
		a=bin(N)[2:]
		count=0
		for i in a:
		    if i=='1':
		        count+=1
		return count



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		N = int(input())
		ob = Solution()
		ans = ob.setBits(N)
		print(ans)




# } Driver Code Ends