# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        d={root:None}
        roots=[]
        if root ==None:
            return 0
        def traverse(head,d,roots):
            if head.left ==None and head.right==None:
                roots.append(head)
            else:
                if head.left!=None:
                    d[head.left]=head
                    traverse(head.left,d,roots)
                if head.right!=None:
                    d[head.right]=head
                    traverse(head.right,d,roots)
        traverse(root,d,roots)
        ans=0
        for i in roots:
            temp=1
            while d[i]!=None:
                temp+=1
                i=d[i]
            ans=max(ans,temp)
        return ans
                