# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if head is None:
            return None
        value=[]
        node=[]
        ptr=head
        c=0
        while ptr !=None:
            c+=1
            if c>=left and c<=right:
                value.append(ptr.val)
                node.append(ptr)
            ptr=ptr.next
        for i in node:
            i.val=value.pop(-1)
        return head