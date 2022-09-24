# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans=[]
        self.dfs(root,[],ans,targetSum)
        return ans
        
    def dfs(self,root,path,ans,rs):
        if root is None:
            return []
        path.append(root.val)
        if root.left is None and root.right is None and rs==root.val:
            ans.append(list(path))
        self.dfs(root.left,path,ans,rs-root.val)
        self.dfs(root.right,path,ans,rs-root.val)
        path.pop()
        return ans
    