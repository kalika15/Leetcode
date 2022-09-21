# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.di=0
        self.traverse(root)
        return self.di
        
    def traverse(self,root):
        if root is None:
            return 0
        l=self.traverse(root.left)
        r=self.traverse(root.right)
        self.di=max(self.di,l+r)
        return max(l,r)+1
    
        