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
    public ListNode deleteDuplicates(ListNode head) {
        // Tc is O(n) and Sc is O(1)
        ListNode current = head;
        if(head == null) return null;
        
        while(current != null &&  current.next!= null){
            
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
            
        }
        return head;
    }
}