# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head) :
            prev = None
            temp = None
            while head:
                temp = head.next
                head.next = prev
                prev = head
                head = temp
            return prev

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        rl1 = self.reverse(l1)
        rl2 = self.reverse(l2)
        root = None
        carry = 0
        while rl1 or rl2 or carry:
            v1,v2 = 0,0
            if rl1:
                v1 = rl1.val
                rl1 = rl1.next
            if rl2:
                v2 = rl2.val
                rl2 = rl2.next
            carry, value = divmod(v1+v2+carry, 10)
            ans = ListNode(value)
            ans.next = root
            root = ans
        return root

        