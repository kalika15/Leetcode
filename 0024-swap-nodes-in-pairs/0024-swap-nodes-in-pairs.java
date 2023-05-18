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
    public ListNode swapPairs(ListNode head) {
        ListNode d=new ListNode(-1);
        ListNode prev=d;
        ListNode curr=head;
        prev.next=curr;
        while(curr!=null && curr.next!=null){
            ListNode n=curr.next;
            curr.next=n.next;
            prev.next=n;
            n.next=curr;
            prev=curr;
            curr=curr.next;


        }
        return d.next;
        
    }
}