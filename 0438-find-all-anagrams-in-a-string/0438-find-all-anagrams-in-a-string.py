class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p):
            return []
        i=0
        j=len(p)-1
        d1={}
        for i in range(len(p)):
            if p[i] in d1:
                d1[p[i]]+=1
            else:
                d1[p[i]]=1
        d2={}
        ans=[]
        for i in range(len(p)):
            if s[i] in d2:
                d2[s[i]]+=1
            else:
                d2[s[i]]=1
        i=0
        if d1==d2:
            ans.append(0)
        while j<len(s)-1:
            if s[i] in d2:
                d2[s[i]]-=1
                if d2[s[i]]==0:
                    del d2[s[i]]
            i+=1
            j+=1
            if s[j] in d2:
                d2[s[j]]+=1
            else:
                d2[s[j]]=1
            if d1==d2:
                ans.append(i)
        return ans