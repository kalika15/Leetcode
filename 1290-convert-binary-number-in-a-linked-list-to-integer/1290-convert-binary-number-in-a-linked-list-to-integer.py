# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        k=[]
        while head!=None:
            k.append(head.val) 
            head=head.next
        s=""
        for i in k:
            s+=str(i)
        return int(s,2)
        