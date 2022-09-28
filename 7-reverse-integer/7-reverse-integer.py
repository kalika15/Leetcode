class Solution:
    def reverse(self, x: int) -> int:
        f=False
        if x<0:
            f=True
            x=-x
        ans=0
        while x:
            ans=ans*10+x%10
            x=x//10
        if ans >=(2**31-1) or ans <=-(2**31):
            return 0
        if f:
            return -ans
        else:
            return ans
        