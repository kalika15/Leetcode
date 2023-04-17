class Solution:
    def findScore(self, nums: List[int]) -> int:
        visited=set()
        min_heap=[]
        ans=0
        for i in range(len(nums)):
            heappush(min_heap,(nums[i],i))
        while(min_heap):
            curr=heappop(min_heap)
            curr_ele=curr[0]
            curr_idx=curr[1]
            if curr_idx not in visited:
                ans+=curr_ele
                visited.add(curr_idx)
                if (curr_idx-1)>=0:
                    visited.add(curr_idx-1)
                if(curr_idx+1)<len(nums):
                    visited.add(curr_idx+1)
        return ans
                