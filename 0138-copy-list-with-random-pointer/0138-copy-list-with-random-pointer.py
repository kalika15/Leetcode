"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head ==None:
            return head
        ptr=head
        while ptr!=None:
            n=Node(ptr.val,ptr.next,None)
            ptr.next=n
            ptr=n.next
        oldptr=head
        while oldptr!=None:
            if oldptr.random==None:
                oldptr.next.random=None
            else:
                oldptr.next.random=oldptr.random.next
            oldptr=oldptr.next.next
        oldptr=head
        newptr=head.next
        newhead=newptr
        while oldptr!=None:
            oldptr.next=newptr.next
            if newptr.next==None:
                newptr.next=None
            else:
                newptr.next=newptr.next.next
        
            oldptr=oldptr.next
            newptr=newptr.next
        return newhead
        
            