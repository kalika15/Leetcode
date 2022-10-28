class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d={}
        for i in strs:
            t=list(i)
            t.sort()
            t="".join(t)
            if t in d:
                d[t].append(i)
            else:
                d[t]=[i]
        ans=[]
        for i in d:
            ans.append(d[i])
        return ans