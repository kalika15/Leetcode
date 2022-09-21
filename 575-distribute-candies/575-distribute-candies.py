class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        k=len(candyType)//2
        m=set(candyType)
        if len(m)<k:
            return len(m)
        if len(m)>k:
            return k
        if len(m)==k:
            return len(m)
            