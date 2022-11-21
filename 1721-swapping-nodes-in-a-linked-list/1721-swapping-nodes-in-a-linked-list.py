# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head==None:
            return None
        s=head
        for i in range(k-1):
            s=s.next
        p=s
        q=head
        while s.next!=None:
            q=q.next
            s=s.next
        temp=p.val
        p.val=q.val
        q.val=temp
        return head
        