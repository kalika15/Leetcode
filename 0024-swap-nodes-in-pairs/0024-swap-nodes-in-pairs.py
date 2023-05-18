# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        d=ListNode(-1)
        prev=d
        curr=head
        prev.next=curr
        while(curr!=None and curr.next!=None):
            n=curr.next
            curr.next=n.next
            prev.next=n
            n.next=curr
            prev=curr
            curr=curr.next
            
        return d.next