# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        curr=list2
        while curr.next!=None:
            curr=curr.next
        p=list1
        c=1
        while c!=a:
            p=p.next
            c+=1
        q=list1
        c2=0
        while c2!=b:
            q=q.next
            c2+=1
        p.next=list2
        curr.next=q.next
        
        return list1