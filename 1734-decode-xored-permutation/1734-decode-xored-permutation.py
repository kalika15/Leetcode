class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        '''ns=[]
        for i in range(1,max(encoded)+1):
            ans.append(i)
        print(ans)
        k=[]
        for i in ans:
            self.gen(i,encoded,k)
            print(k)
            if self.valid(k):
                return k
            else:
                pass
            
            
    def gen(self,first,encoded,ans):
        ans=[first]
        for i in encoded:
            ans.append(ans[0]^i)
        return ans
    def valid(self,arr):
        c=0
        for i in range(len(arr)):
            if arr[i]<=arr[0]:
                c+=1
        if c==len(arr):
            return True
        return False
            '''
        n=len(encoded)+1
        k=0
        for i in range(1,n+1):
            k^=i
        m=0
        for i in range(1,len(encoded),2):
            m^=encoded[i]
        f=k^m
        ans=[f]
        for i in encoded:
            ans.append(ans[-1]^i)
        return ans