class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        n=int(len(arr)/4)+1
        print(n)
        d=Counter(arr)
        for i in d:
            if d[i]>=n:
                return i
        