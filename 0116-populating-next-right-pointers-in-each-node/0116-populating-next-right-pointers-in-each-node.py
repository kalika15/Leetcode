"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        q=[[root]]
        while q:
            n=q.pop(0)
            level=[]
            for i in range(len(n)):
                if i!=len(n)-1:
                    n[i].next=n[i+1]
                if n[i].left:
                    level.append(n[i].left)
                if n[i].right:
                    level.append(n[i].right)
            if level!=[]:
                q.append(level)
        return root