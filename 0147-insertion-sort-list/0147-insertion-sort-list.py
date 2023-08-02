# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next



# giving tle
# class Solution:
#     def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
#         dummy=ListNode(-1)
#         prev=dummy
#         prev.next=head
#         curr=head.next
#         n=head
#         while(curr):
#             if n.val<curr.val:
#                 n=curr
#                 curr=curr.next
#                 continue
#             if prev.val<curr.val and curr.val<=prev.next.val:
#                 n.next=curr.next
#                 curr.next=prev.next
#                 prev.next=curr
#                 curr=n.next
#             elif prev.val>curr.val:
#                 prev=dummy
#             else:
#                 prev=prev.next

#         return dummy.next

class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        sortedHead=None
        curr=head
        while curr:
            node=curr.next
            sortedHead=self.insertNode(sortedHead,curr)
            curr=node
        return sortedHead


    def insertNode(self,sortedHead, Node):
        if not sortedHead or Node.val<sortedHead.val:
            Node.next=sortedHead
            sortedHead=Node
        else:
            curr=sortedHead
            while curr.next and curr.next.val<Node.val:
                curr=curr.next
            Node.next=curr.next
            curr.next=Node
        return sortedHead

