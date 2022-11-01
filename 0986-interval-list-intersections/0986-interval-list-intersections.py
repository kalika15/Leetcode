class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        ans=[]
        i=0
        j=0
        while i<=len(firstList)-1 and j<=len(secondList)-1:
            s=max(firstList[i][0],secondList[j][0])
            e=min(firstList[i][1],secondList[j][1])
            if s<=e:
                ans.append([s,e])
            if firstList[i][1]<=secondList[j][1]:
                i+=1
            else:
                j+=1
        return ans