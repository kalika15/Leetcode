#User function Template for python3

class Solution:
	def LongestBitonicSequence(self, nums):
		# Code here
		 n = len(nums)

         LIS = [1] *n 
        
         LDIS = [1] *n 
        
         
        
         for i in range(1,n):
        
             for j in range(i):
        
                 if nums[i] > nums[j] and LIS[i] < LIS[j] + 1:
        
                     LIS[i] = LIS[j] + 1
        
                     
        
         for i in range(n-2,-1,-1):
        
             for j in range(n-1,i,-1):
        
                 if nums[i] > nums[j] and LDIS[i] < LDIS[j] + 1:
        
                     LDIS[i] = LDIS[j] + 1
        
                     
        
         return max(LIS[i] + LDIS[i] -1 for i in range(n))


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		nums = list(map(int, input().split()))
		ob = Solution()
		ans = ob.LongestBitonicSequence(nums)
		print(ans)
# } Driver Code Ends