# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:
            return None
        if head.next is None:
            return head
        s=head
        c=1
        while s.next!=None:
            c+=1
            s=s.next
        s.next=head
        l=head
        k=k%c
        for i in range(c-k-1):
            l=l.next
        ans=l.next
        l.next=None
        return ans