class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        '''max_heap=[]
        for i in range(len(nums)):
            for j in range(0,len(nums)):
                if i!=j:
                    m=(nums[i]-1)*(nums[j]-1)
                    heappush(max_heap,-m)
        return -(heappop(max_heap))'''
        nums.sort()
        return ((nums[-1]-1)*(nums[-2]-1))