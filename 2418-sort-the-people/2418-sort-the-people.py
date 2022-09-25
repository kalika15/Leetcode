class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        d={}
        for i in range(len(names)):
            d[heights[i]]=names[i]
        print(d)
        k=(d.keys())
        k=reversed(sorted(k))
        ans=[]
        for i in k:
            l=list(d.values())[list(d.keys()).index(i)]
            ans.append(l)
        return ans