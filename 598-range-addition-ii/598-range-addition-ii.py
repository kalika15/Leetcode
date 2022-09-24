class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        r=m
        c=n
        for i in ops:
            r=min(r,i[0])
            c=min(c,i[1])
        return r*c
                