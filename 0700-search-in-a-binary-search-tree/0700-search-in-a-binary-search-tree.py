# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        ans=[]
        if root==None:
            return None
        return self.bfs(root,val)
    def bfs(self,root,ans):
        if root==None:
            return None
        if root.val==ans:
            return root
        a=self.bfs(root.left,ans)
        b=self.bfs(root.right,ans)
        if a!=None:
            return a
        if b!=None:
            return b
        return None