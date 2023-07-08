#User function Template for python3
class Solution:  
    def findTriplets(self, arr, n):
        arr = sorted(arr) 
        hmap = {}
        for i in range(len(arr)):
            if arr[i] not in hmap :
                hmap[arr[i]] = []
                hmap[arr[i]].append(i)
            else:
                hmap[arr[i]].append(i)
        for i in range(len(arr)):
            for j in range(i+1,len(arr)):
                target = -arr[i] - arr[j]
                if target in hmap:
                    if hmap[target][-1] > j:
                        return True
        
        return False

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n=int(input())
        a=list(map(int,input().strip().split()))
        if(Solution().findTriplets(a,n)):
            print(1)
        else:
            print(0)
# } Driver Code Ends