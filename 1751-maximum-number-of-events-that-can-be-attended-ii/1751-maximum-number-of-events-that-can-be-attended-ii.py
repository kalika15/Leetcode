class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort()
        dp={}
        return self.dfs(0,k,-1,events,dp)
    
    def dfs(self,i,k,end,events,dp):
        if i>=len(events) or k==0:
            return 0
        if (i,k,end) in dp:
            return  dp[(i,k,end)]
        value=0
        if events[i][0]>end:
            value=self.dfs(i+1,k-1,events[i][1],events,dp)+events[i][2]
        value=max(value,self.dfs(i+1,k,end,events,dp))
        dp[(i,k,end)]=value
        return value