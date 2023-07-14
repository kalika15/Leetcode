class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        t=sum(arr)
        es=t//3
        if t%3!=0:
            return False
        s=0
        c=0
        for i in arr:
            if c==2:
                return True
            s+=i
            if s==es:
                c+=1
                s=0
        return False