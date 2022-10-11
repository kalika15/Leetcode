# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        ans=[]
        q=deque()
        q.append(root)
        while q:
            level=[]
            for i in range(len(q)):
                n=q.popleft()
                if n:
                    q.append(n.left)
                    q.append(n.right)
                    level.append(n.val)
            if level!=[]:
                ans.append(level)
        return ans