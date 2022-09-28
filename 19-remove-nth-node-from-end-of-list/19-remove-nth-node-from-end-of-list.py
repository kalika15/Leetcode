# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        k=[]
        while head!=None:
            k.append(head.val)
            head=head.next
        k=k[::-1]
        for i in range(len(k)):
            if i+1==n:
                k.pop(i)
                break
        k=k[::-1]
        i=0
        if len(k)==0:
            return None
        head=ListNode(k[0])
        curr=head
        for i in range(1,len(k)):
            temp=ListNode(k[i])
            curr.next=temp
            curr=temp
        return head
            
        