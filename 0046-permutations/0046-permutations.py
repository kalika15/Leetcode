class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result=[]
        self.solve(nums,0,result)
        return result
    def swap(self,a,b,nums):
        nums[a],nums[b]=nums[b],nums[a]
    def solve(self,nums,start,result):
        if start==len(nums)-1:
            result.append(nums[::])
        for i in range(start,len(nums)):
            self.swap(i,start,nums)
            self.solve(nums,start+1,result)
            self.swap(i,start,nums)


