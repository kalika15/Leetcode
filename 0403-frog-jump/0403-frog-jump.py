class Solution:
    def canCross(self, stones: List[int]) -> bool:
        target=stones[-1]
        d={}
        for i in range(len(stones)):
            s=set()
            d[stones[i]]=s
        d[stones[0]].add(1)
        for i in range(len(stones)):
            curr=stones[i]
            jumps=d[curr]
            for jump in jumps:
                new=curr+jump
                if new==target:
                    return True
                if new in d:
                    if jump-1>0:
                        d[new].add(jump-1)
                    d[new].add(jump)
                    d[new].add(jump+1)
        return False