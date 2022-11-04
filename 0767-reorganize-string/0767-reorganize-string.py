class Solution:
    def reorganizeString(self, s: str) -> str:
        d={}
        for i in range(len(s)):
            if s[i] not in d:
                d[s[i]]=1
            else:
                d[s[i]]+=1
        max_heap=[]
        for char,freq in d.items():
            heappush(max_heap,(-freq,char))
        ans=""
        while len(max_heap)>1:
            f1,c1=heappop(max_heap)
            f2,c2=heappop(max_heap)
            ans+=c1
            ans+=c2
            f1+=1
            f2+=1
            if f1!=0:
                heappush(max_heap,(f1,c1))
            if f2!=0:
                heappush(max_heap,(f2,c2))

        if len(max_heap)>0:
            if len(max_heap)==1:
                k,l=heappop(max_heap)
                if k==-1:
                    ans+=l
                    return ans
                
                else:
                    return ""

        return ans