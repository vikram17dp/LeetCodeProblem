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
class Solution { // tc is O(n) and sc is O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode curr = head;

        while(curr != null){
            // skip all the duplicate values
            if(curr.next != null && curr.val == curr.next.val){
                // skip all the repatitive values too
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                // move prev into curr next postion
                prev.next = curr.next;
            }else{
                // curr is unique, move prev
                prev = prev.next;
            }
            // move curr at the end
            curr = curr.next;
        }
        return dummy.next;
    }
}