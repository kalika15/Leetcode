# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        dummy1=ListNode(-1)
        p=dummy1
        dummy2=ListNode(-1)
        q=dummy2
        temp=head
        while temp!=None:
            if temp.val<x:
                c=ListNode(temp.val)
                p.next=c
                p=p.next
            else:
                k=ListNode(temp.val)
                q.next=k
                q=q.next
            temp=temp.next
        p.next=dummy2.next
        q.next=None
        return dummy1.next
                