import sys
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        d={}
        for i in range(len(list1)):
            if list1[i] in list2:
                k=i+list2.index(list1[i])
                d[list1[i]]=k
        m=min(d.values())
        ans=[]
        n=list(d.values())
        for i in n:
            if m==i:
                k=list(d.keys())[list(d.values()).index(m)]
                ans.append(k)
                d.pop(k)
        return ans