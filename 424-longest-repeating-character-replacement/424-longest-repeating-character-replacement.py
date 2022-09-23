class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        d={}
        ws=0
        we=0
        m=0
        mf=0
        while we!=len(s):
            d[s[we]]=d.get(s[we],0)+1
            mf=max(mf,d.get(s[we],0))
            if we-ws+1-mf>k:
                d[s[ws]]-=1
                ws+=1
                mf=max(d.values())
                d[s[we]]-=1
            else:
                m=max(m,we-ws+1)
                we+=1 
        return m
            
        