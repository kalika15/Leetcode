class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans=[]
        self.solve(s,[],ans)
        return ans
    def palindrome(self,s):
        if s==s[::-1]:
            return True
        return False
    def solve(self,s,temp,ans):
        if s=="":
            ans.append(temp)
            return
        for i in range(1,len(s)+1):
            if self.palindrome(s[:i]):
                self.solve(s[i:],temp+[s[:i]],ans)