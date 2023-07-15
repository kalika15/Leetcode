class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        result=[]
        for i in range(left,right+1):
            num=i
            temp=[]
            for j in range(int(math.log10(num))+1):
                temp.append(num%10)
                num//=10
            flag=0
            for j in range(len(temp)):
                if temp[j]==0:
                    flag=1
                    break
                if i%int(temp[j])!=0:
                    flag=1
                    break
            if flag==0:
                result.append(i)
        return result
