"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if root is None:
            return 0
        else:
            if root.children :
                return max(self.maxDepth(i) for i in root.children)+1
            else:
                return 1