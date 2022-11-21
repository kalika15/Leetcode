# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        curr=head
        p=None
        while curr!=None:
            if curr.val==val:
                if p!=None:
                    p.next=curr.next
                else:
                    head=curr.next
                curr=curr.next
            else:
                p=curr
                curr=curr.next
        return head