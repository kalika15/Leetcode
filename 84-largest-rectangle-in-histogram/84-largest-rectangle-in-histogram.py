class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack=[]
        ser=[]
        for i in range(len(heights)-1,-1,-1):
            while len(stack)!=0 and stack[-1][0]>=heights[i]:
                stack.pop()
            if len(stack)!=0:
                ser.append(stack[-1][1])
            else:
                ser.append(len(heights))
            stack.append([heights[i],i])
        ser=ser[::-1]
        stack1=[]
        sel=[]
        for i in range(len(heights)):
            while len(stack1)!=0 and stack1[-1][0]>=heights[i]:
                stack1.pop()
            if len(stack1)!=0:
                sel.append(stack1[-1][1])
            else:
                sel.append(-1)
            stack1.append([heights[i],i])
        m=0
        for i in range(len(heights)):
            m=max(m,heights[i]*((ser[i]-sel[i])-1))
        return m
            