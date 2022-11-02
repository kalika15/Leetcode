
class Solution:
    def frequencySort(self, s: str) -> str:
        d={}
        for i in s:
            d[i]=d.get(i,0)+1
        max_heap=[]
        for ch,freq in d.items():
            heappush(max_heap,(-freq,ch))
        prev_ch=None
        prev_freq=None
        temp=""
        while max_heap:
            curr_freq,curr_char=heappop(max_heap)
            curr_freq=-(curr_freq)
            temp+=curr_char*curr_freq
        return temp
                