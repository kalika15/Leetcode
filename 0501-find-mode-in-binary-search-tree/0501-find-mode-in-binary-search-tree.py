# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        l=[]
        self.dfs(root,l)
        d=Counter(l)
        ans=[]
        f=0
        if len(l)==1:
            return l
        for i in d:
            m=max(d.values())
            if m==d[i]:
                ans.append(i)
                f=1
            
        if f==0:
            for i in d:
                if d[i]==1:
                    ans.append(i)
        return ans
            
    def dfs(self,root,ans):
        if root is None:
            return []
        self.dfs(root.left,ans)
        ans.append(root.val)
        self.dfs(root.right,ans)
        return ans
    