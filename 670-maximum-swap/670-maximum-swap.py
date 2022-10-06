class Solution:
    def maximumSwap(self, num: int) -> int:
        num=list(str(num))
        f=0
        for i in range(len(num)):
            m=-1
            for j in range(i+1,len(num)):
                if num[i]<num[j]:
                    if m==-1:
                        m=j
                    elif num[m]<=num[j]:
                        m=j
            if m!=-1:
                num[i],num[m]=num[m],num[i]
                f+=1
            if f==1:
                break
        return int("".join(num))