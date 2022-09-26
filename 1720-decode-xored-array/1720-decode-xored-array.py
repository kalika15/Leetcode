class Solution:
    def decode(self, encoded: List[int], first: int) -> List[int]:
        ans=[]
        ans.append(first)
        for i in range(len(encoded)):
            ans.append(encoded[i]^ans[i])
        return ans