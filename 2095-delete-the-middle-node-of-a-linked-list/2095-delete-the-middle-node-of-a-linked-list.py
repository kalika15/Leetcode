# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        s=head
        prev=None
        f=head
        while f!=None and f.next!=None:
            prev=s
            s=s.next
            f=f.next.next

        if prev==None:
            return None
        prev.next=s.next
        return head