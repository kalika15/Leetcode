class Solution:
    def calPoints(self, operations: List[str]) -> int:
        ans=[]
        for i in range(len(operations)):
            if operations[i]=='+':
                ans.append(int(ans[-1])+int(ans[-2]))
            elif operations[i]=='D':
                x=2*int(ans[-1])
                ans.append(x)
            elif operations[i]=='C':
                ans.pop()
            else:
                ans.append(int(operations[i]))
        return sum(ans)