# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        return self.solve(root,low,high)
        
    def solve(self,root,low,high):
        if root is None:
            return None
        if root.val>high:
            return self.solve(root.left,low,high)
        elif root.val<low:
            return self.solve(root.right,low,high)
        else:
            root.right=self.solve(root.right,low,high)
            root.left=self.solve(root.left,low,high)
        return root