# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans=""
        return self.solve(root,ans)
        return ans
    def solve(self,root,ans):
        if root.left is None and root.right is None:
            ans=ans+str(root.val)
            return int(ans,2)
        ans+=str(root.val)
        a=b=0
        if root.left:
            a=self.solve(root.left,ans)
        if root.right:
            b=self.solve(root.right,ans)
        return a+b