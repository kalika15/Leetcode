class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        max_heap=[]
        stop=0
        for i in stations:
            pos,fuel=i[0],i[1]
            while startFuel<i[0]:
                if len(max_heap)==0:
                    return -1
                k=-(heappop(max_heap))
                startFuel+=k
                stop+=1
            heappush(max_heap,-fuel)
        while startFuel<target:
            if len(max_heap)==0:
                return -1
            k=-(heappop(max_heap))
            startFuel+=k
            stop+=1
                    
        return stop