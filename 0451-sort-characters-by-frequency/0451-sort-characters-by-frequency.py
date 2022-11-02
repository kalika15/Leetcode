class Solution:
    def frequencySort(self, s: str) -> str:
        k=dict(Counter(s))
        m=sorted(k.values(),reverse=True)
        s={}
        for i in m:
            for j in k:
                if k[j]==i:
                    s[j]=k[j]
        ans=""
        for i in s:
            for j in range(s[i]):
                ans+=i
        return ans
        