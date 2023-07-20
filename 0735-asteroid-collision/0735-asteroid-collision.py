class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack=[]
        stack.append(asteroids[0])
        for i in range(1,len(asteroids)):
            a=asteroids[i]
            while len(stack)>0 and stack[-1]>0 >a:
                if stack[-1]<abs(a):
                    stack.pop()
                    continue
                elif stack[-1]==abs(a):
                    stack.pop()
                break
            else:
                stack.append(a)
        return stack
