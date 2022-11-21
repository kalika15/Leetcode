# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p=headA
        q=headB
        while p!=q:
            p=p.next
            q=q.next
            if p==None and q==None:
                return None
            if p==None:
                p=headB
            if q==None:
                q=headA
            
        return p
                