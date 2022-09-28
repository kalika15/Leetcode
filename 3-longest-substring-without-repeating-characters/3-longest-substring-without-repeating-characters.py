class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i=0
        j=0
        ans=set()
        k=0
        if s=="":
            return 0
        while i<len(s):
            if s[i] not in ans:
                ans.add(s[i])
                i+=1
                k=max(k,len(ans))
            else:
                ans.remove(s[j])
                j+=1
        return k
                
            

                
        
        