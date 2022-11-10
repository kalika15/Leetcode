# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        a=(self.minDepth(root.left)+1)
        b=(self.minDepth(root.right)+1)
        if a==1:
            return b
        if b==1:
            return a
        
        return min(a,b)