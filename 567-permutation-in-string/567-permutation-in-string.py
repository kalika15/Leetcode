class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        d=dict(Counter(s1))
        ws=we=0
        m=0
        k=0
        while we<len(s2):
            if s2[we] in d:
                d[s2[we]]-=1
                if d[s2[we]]==0:
                    m+=1
            k=we-ws+1
            if k==len(s1) :
                if m==len(d):
                    return True
                else:
                    if s2[ws] in d:
                        if d[s2[ws]]==0:
                            m-=1
                        d[s2[ws]]+=1
                        
                ws+=1
            we+=1
        return False