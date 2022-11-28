class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        d_win={}
        d_lose={}
        for i in range(len(matches)):
            if matches[i][0] in d_win:
                d_win[matches[i][0]]+=1
            else:
                d_win[matches[i][0]]=1
            if matches[i][1] in d_lose:
                d_lose[matches[i][1]]+=1
            else:
                d_lose[matches[i][1]]=1
        ans=[]
        l=[]
        for i,j in d_win.items():
            if i not in d_lose:
                l.append(i)
        l.sort()
        ans.append(l)
        l=[]
        for i,j in d_lose.items():
            if j==1:
                l.append(i)
        l.sort()
        ans.append(l)
        return ans