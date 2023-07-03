class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s)!=len(goal) or len(s)==1:
            return False
        if set(list(s))==set(list(goal)) and len(set(list(goal)))==1:
            return True
        dic_s={}
        dic_g={}
        for i in range(len(s)):
            if s[i] not in goal:
                return False
            if s[i] not in dic_s:
                dic_s[s[i]]=[]
            dic_s[s[i]].append(i)
            if goal[i] not in dic_g:
                dic_g[goal[i]]=[]
            dic_g[goal[i]].append(i)
        c=0
        for i,j in dic_s.items():
            b=dic_g[i]
            if len(b)!=len(j):
                return False
            for k in j:
                if k not in b:
                    c+=1
            if s==goal and len(j)>=2:
                return True
           
        print(c)
        if c==2:
            return True
        return False
        