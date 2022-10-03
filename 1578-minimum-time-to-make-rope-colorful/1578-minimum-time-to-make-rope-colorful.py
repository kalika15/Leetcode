class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        stack=[]
        c=0
        for i in range(len(colors)):
            if  len(stack)!=0 and colors[i]==stack[-1][0]:
                if neededTime[i]>stack[-1][1]:
                    c+=stack[-1][1]
                    stack.pop()
                    stack.append([colors[i],neededTime[i]])
                else:
                    c+=neededTime[i]
                    
            else:
                stack.append([colors[i],neededTime[i]])
        print(stack)
        return c