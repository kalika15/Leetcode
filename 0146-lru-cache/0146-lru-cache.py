class ListNode:
    def __init__(self,val,value,next=None,prev=None):
        self.val=val
        self.value=value
        self.next=next
        self.prev=prev
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity=capacity
        self.d={}
        self.head=ListNode(-1,-1)
        self.tail=ListNode(-1,-1)
        self.head.next=self.tail
        self.tail.prev=self.head

    def get(self, key: int) -> int:
        if key in self.d:
            x=self.d[key]
            a=self.Deletion(x)
            new=ListNode(key,a[1])
            self.Insertion(new)
            return a[1]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.d:
            x=self.d[key]
            self.Deletion(x)
        new=ListNode(key,value)
        if len(self.d)==self.capacity:
            self.Deletion(self.tail.prev)
        self.Insertion(new)
        
    def Insertion(self,node):
        self.d[node.val]=node
        node.next=self.head.next
        node.next.prev=node
        self.head.next=node
        node.prev=self.head
        
    def Deletion(self,node):
        del self.d[node.val]
        node.prev.next=node.next
        node.next.prev=node.prev
        return [node.val,node.value]

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)