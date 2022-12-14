class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans=[-1,-1]
        
        start=end=low=0
        high=len(nums)-1
        while True:
            start=self.binarysearch(nums,low,high,target)
            if start!=-1:
                ans[0]=start
                high=start-1
            else:
                break
        low=0
        high=len(nums)-1
        while True:
            end=self.binarysearch(nums,low,high,target)
            if end!=-1:
                ans[1]=end
                low=end+1
            else:
                break

            
        return ans
    def binarysearch(self,arr,low,high,x):
        while high>=low:
            mid=low+(high-low)//2
            if arr[mid]==x:
                return mid
            elif arr[mid]>x:
                high=mid-1
            else:
                low=mid+1
        else:
            return -1

            