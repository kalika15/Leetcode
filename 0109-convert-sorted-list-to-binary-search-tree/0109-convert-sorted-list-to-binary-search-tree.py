# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        temp=[]
        while head !=None:
            temp.append(head.val)
            head=head.next
        
        def solve(left,right):
            if left>right:
                return None
            mid=(left+right)//2
            n=TreeNode(temp[mid])
            n.left=solve(left,mid-1)
            n.right=solve(mid+1,right)
            return n
        return solve(0,len(temp)-1)