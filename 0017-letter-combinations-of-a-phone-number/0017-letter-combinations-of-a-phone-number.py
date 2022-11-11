class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        d={'2':"abc",'3':"def",'4':"ghi",'5':"jkl",'6':"mno",'7':"pqrs",'8':"tuv",'9':"wxyz"}
        if digits=="":
            return []
        temp=[]
        for i in range(len(digits)):
            if digits[i] in d:
                temp.append(d[digits[i]])
        combs=product(*temp)
        ans=[]
        for i in combs:
            if not i:
                continue
            string="".join(i)
            ans.append(string)
        return ans
        
            
            