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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result=new ListNode[k];
        ListNode temp=head;
        int count=0;
        while(temp!=null) {
            temp=temp.next;
            count++;
        }
        int min_node=count/k;
        int extra_node=count%k;
        temp=head;
        
        for (int i=0; i<k; i++) {
            int node=min_node+(extra_node>0 ?1 :0);
            if(node==0) {
                result[i]=null;
            }
            else{
                result[i]=temp;
                for(int j=0; j<node-1; j++) {
                    temp=temp.next;
                }
                ListNode next=temp.next;
                temp.next=null;
                temp=next;
            }
            extra_node--;
        }
        return result;
    }
}