class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        stack=[]
        i=0
        s=""
        while i<len(bits):
            s=""
            if bits[i]==1:
                s+=str(bits[i])
                i+=1
                s+=str(bits[i])
                i+=1
                stack.append(s)
            else:
                s+=str(bits[i])
                i+=1
                stack.append(s)
        if stack[-1]=='0':
            return True
        return False