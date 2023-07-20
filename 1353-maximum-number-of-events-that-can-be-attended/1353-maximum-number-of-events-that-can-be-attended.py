class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        events.sort()
        n=0
        for i in range(len(events)):
            n=max(n,events[i][1])
        attended=0
        d=0
        idx=0
        heap=[]
        for day in range(1,n+1):
            while idx<len(events) and events[idx][0]==day:
                heappush(heap,events[idx][1])
                idx+=1
            while heap and heap[0]<day:
                heappop(heap)
            if heap:
                heappop(heap)
                attended+=1
        return attended



