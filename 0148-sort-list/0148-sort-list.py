# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        min_heap=[]
        if head is None:
            return head
        curr=head
        while curr!=None:
            heappush(min_heap,curr.val)
            curr=curr.next
        n=ListNode(heappop(min_heap))
        p=n
        while min_heap:
            l=ListNode(heappop(min_heap))
            p.next=l
            p=p.next
        return n