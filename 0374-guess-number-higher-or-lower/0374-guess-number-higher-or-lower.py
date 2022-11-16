# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        i=1
        j=n
        while i<=j:
            m=(i+j)//2
            p=guess(m)
            if p==0:
                return m
            elif p==1:
                i=m+1
            else:
                j=m-1
                
                