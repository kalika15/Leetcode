# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        s=head
        f=head.next
        while f!=None:
            if s.val!=f.val:
                s=s.next
                f=f.next
            else:
                s.next=f.next
                f=f.next
        return head
        