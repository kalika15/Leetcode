# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap=[]
        for i in range(len(lists)):
            if lists[i]:
                heappush(min_heap,(lists[i].val,i))
        newhead=ListNode()
        curr=newhead
        while min_heap:
            temp=heappop(min_heap)
            curr.next=lists[temp[1]]
            lists[temp[1]]=lists[temp[1]].next
            if lists[temp[1]]!=None:
                heappush(min_heap,(lists[temp[1]].val,temp[1]))
            curr=curr.next
        return newhead.next
            