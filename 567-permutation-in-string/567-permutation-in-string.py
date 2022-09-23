class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        pattern=s1
        s=s2
        
        hashMap={}
        for i in pattern:
            hashMap[i]=hashMap.get(i,0)+1
        
        matched=0
        ws=0
        we=0
        
        while we<len(s):
            ch=s[we]
            if ch in hashMap:
                hashMap[ch]-=1
                if hashMap[ch]==0:
                    matched+=1
            if (we-ws+1)==len(s1):
                
                if len(hashMap)==matched:
                    return True
                else:
                    ch=s[ws]
                    if ch in hashMap:
                        if hashMap[ch]==0:
                            matched-=1
                        hashMap[ch]+=1
                ws+=1
                    
            we+=1
        return False
        
            
            
            