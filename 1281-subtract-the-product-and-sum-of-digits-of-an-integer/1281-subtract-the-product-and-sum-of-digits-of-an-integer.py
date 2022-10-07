class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        n=list(str(n))
        p=1
        s=0
        for i in n:
            p*=int(i)
            s+=int(i)
        return p-s