/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) {
            return null;
        }
        ListNode[] value=new ListNode[right-left+1];
        ListNode[] node=new ListNode[right-left+1];
        ListNode ptr=head;
        int c=0;
        while(ptr!=null) {
            c++;
            if(c>=left && c<=right){
                value[c-left]=ptr;
                node[c-left]=new ListNode(ptr.val);
            }
            ptr=ptr.next;
        }
        for(int i=0; i<node.length; i++){
            value[i].val=node[node.length-1-i].val;
        }
        return head;
    }
}