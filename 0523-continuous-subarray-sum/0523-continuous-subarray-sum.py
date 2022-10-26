class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        d={0:-1}
        s=0
        for i,n in enumerate(nums):
            s+=n
            r=s%k
            if r not in d:
                    d[r]=i
            elif (r in d) and ((i-(d[r]+1)+1)>=2):
                return True
        return False