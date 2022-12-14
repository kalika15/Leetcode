class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l=[]
        for i in range(len(matrix)):
            l.extend(matrix[i])
        return self.binarysearch(l,0,len(l)-1,target)
        
    def binarysearch(self,arr,low,high,target):
        while high>=low:
            mid=low+(high-low)//2
            if arr[mid]==target:
                return True
            elif arr[mid]>target:
                high=mid-1
            else:
                low=mid+1
        else:
            return False