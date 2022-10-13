class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        ans=[]
        m=0
        for i in range(len(arr)):
            k=arr[i+1:]
            for i in k:
                if i>m:
                    m=i
            ans.append(m)
            m=0
            k=[]
        ans[-1]=-1
        return ans
        