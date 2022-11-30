class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        d={}
        for i in range(len(arr)):
            if arr[i] in d:
                d[arr[i]]+=1
            else:
                d[arr[i]]=1
        c=0
        arr=[]
        for i,j in d.items():
            if j in arr:
                c=1
                break
            else:
                arr.append(j)
        if c==1:
            return False
        return True