class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(ListNode prev, int key, int val, ListNode next){
        this.prev=prev;
        this.key=key;
        this.val=val;
        this.next=next;
    }
}

class MyHashMap {
    ListNode head;
    ListNode last;
    public MyHashMap() {
        head=new ListNode(null,-1,-1,null);
        last=head;

    }
    
    public void put(int key, int value) {
        ListNode curr=head;
        while(curr!=null){
            if(curr.key==key){
                curr.val=value;
                return;
            }
            curr=curr.next;
        }
        ListNode Node=new ListNode(last, key, value, null);
        last.next=Node;
        last=last.next;
        
    }   
    
    public int get(int key) {
        ListNode curr=head;
        int val=0;
        while(curr!=null){
            if(curr.key==key){
                return curr.val;
            }
            curr=curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode curr=head;
        while(curr!=null){
            if(curr.key==key){
                if(curr.prev!=null) {
                    curr.prev.next=curr.next;
                }
             
                if(curr.next!=null) {
                    curr.next.prev=curr.prev;
                    return;
                }
                else{
                    curr.prev.next=null;
                    last=curr.prev;
                    return;
                }
            }
            curr=curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */