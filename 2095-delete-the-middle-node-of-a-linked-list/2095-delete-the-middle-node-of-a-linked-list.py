# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head.next :
            return None
        ptr1,ptr2=head.next,head
        while ptr1.next and ptr1.next.next:
            ptr1=ptr1.next.next
            ptr2=ptr2.next
        ptr2.next=ptr2.next.next
        return head
    