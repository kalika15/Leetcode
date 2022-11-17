# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        ans=[]
        self.traverse(root,ans)
        t=TreeNode(ans[0])
        
        p=t
        for i in range(1,len(ans)):
            p.right=TreeNode(ans[i])
            p=p.right
        return t
        
    def traverse(self,root,ans):
        if root is None:
            return root
        self.traverse(root.left,ans)
        ans.append(root.val)
        self.traverse(root.right,ans)
        return ans

            