class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        c=0
        new=[]
        for i in range(len(intervals)):
            curr=intervals[i]
            if curr[0]<=newInterval[0]:
                c+=1
                new.append(curr)
        new.append(newInterval)
        new.extend(intervals[c:])
        per=new[0]
        ans=[]
        for i in range(1,len(new)):
            cur=new[i]
            if cur[0]<=per[1]:
                per[1]=max(cur[1],per[1])
            else:
                ans.append(per)
                per=cur
        ans.append(per)
        return ans