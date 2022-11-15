# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        l=[]
        self.preorder(root,l)
        return len(l)
        
    def preorder(self,root,ans):
        if root is None:
            return 0
        self.preorder(root.left,ans)
        ans.append(root.val)
        self.preorder(root.right,ans)
        return ans