"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        ans=[]
        if root is None:
            return ans
        res=[]
        ans.append(root)
        while ans:
            a=[]
            n=len(ans)
            while n>0:
                m=ans.pop(0)
                a.append(m.val)
                n-=1
                for j in m.children:
                    if j:
                        ans.append(j)
            res.append(a)
        return res