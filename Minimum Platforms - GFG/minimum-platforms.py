#User function Template for python3
import heapq 
class Solution:    
    #Function to find the minimum number of platforms required at the
    #railway station such that no train waits.
    def minimumPlatform(self,n,arr,dep):
        # code here
        A=[]
        for i in range(n):
            A.append([arr[i],dep[i]])
        min_heap=[]
        A.sort()
        heapq.heappush(min_heap,A[0][1])
        for i in range(1,len(A)):
            if A[i][0]>min_heap[0]:
                heapq.heappop(min_heap)
            heapq.heappush(min_heap,A[i][1])

        return len(min_heap)
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n = int(input())
        arrival = list(map(int, input().strip().split()))
        departure = list(map(int, input().strip().split()))
        ob=Solution()
        print(ob.minimumPlatform(n,arrival,departure))
# } Driver Code Ends