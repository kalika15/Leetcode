class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        ans=[]
        k=intervals[0]
        for i in range(1,len(intervals)):
            curr=intervals[i]
            if curr[0]<=k[1]:
                k[1]=max(k[1],curr[1])
            else:
                ans.append(k)
                k=curr
        ans.append(k)
        return ans
                