class DoublyListNode:
    def __init__(self,key,val,next=None,prev=None):
        self.key=key
        self.val=val
        self.prev=prev
        self.next=next
        
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity=capacity
        self.d={}
        self.head=DoublyListNode(0,0)
        self.tail=DoublyListNode(0,0)
        self.head.next=self.tail
        self.tail.prev=self.head
        
    def get(self, key: int) -> int:
        
        if key in self.d:
            x=self.d[key]
            self.deletion(x)
            self.insertion(x)
            
            return x.val
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        
        if key in self.d:
            self.deletion(self.d[key])
        newhead=DoublyListNode(key,value)
        self.insertion(newhead)
        self.d[key]=newhead
        if len(self.d)>self.capacity:
            newhead=self.head.next
            self.deletion(newhead)
            del self.d[newhead.key]
        
    def insertion(self,node):
        self.tail.prev.next, node.next = node, self.tail
        self.tail.prev, node.prev = node, self.tail.prev
    
    def deletion(self,node):
        node.prev.next=node.next
        node.next.prev=node.prev
    

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
