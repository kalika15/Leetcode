# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.Solve(root,targetSum)
    
    def Solve(self,root,targetSum):
        if root is None:
            return False
        else:
            targetSum=targetSum-root.val
            if root.left is None and root.right is None:
                if targetSum==0:
                    return True
            return self.Solve(root.left,targetSum) or self.Solve(root.right,targetSum)
        