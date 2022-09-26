class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        '''for i in range(len(equations)):
            if equations[i][0]=='a' or equations[i][0]=='b':
                if equations[i][1]=='=' and equations[i][2]=='=':
                    if equations[i+1][0]=='a' or equations[i+1][0]=='b':
                        if equations[i+1][1]=='=' and equations[i+1][2]=='=':
                            return True
        return False'''
        '''s=""
        for i in range(len(equations)):
            k=equations[i].split()
            s="".join(k)'''
        p={}
        for i in range(ord('a'),ord('z')+1):
            p[chr(i)]=chr(i)
        def find(val):
            if p[val]==val:
                return val
            p[val]=find(p[val])
            return p[val]
        for x,sign,_,y in equations:
            if sign=='=':
                px=find(x)
                py=find(y)
                p[px]=py
        for x,sign,_,y in equations:
            if sign=='!' and find(x)==find(y):
                return False
        return True
            