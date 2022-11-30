# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr=head
        stack=[]
        while curr!=None:
            while len(stack)!=0 and stack[-1]<curr.val:
                stack.pop()
            stack.append(curr.val)
            curr=curr.next
        new=ListNode(0)
        p=new
        while len(stack)!=0:
            a=stack.pop(0)
            new.next=ListNode(a)
            new=new.next
            
        return p.next
                    