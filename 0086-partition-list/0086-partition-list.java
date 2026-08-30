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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallDummy = small;
        ListNode bigDummy = big;
        ListNode curr = head;
        
        while(curr != null){
            // check < x
            if(curr.val < x){
                small.next = curr;
                small = small.next;
            }else{
                big.next = curr;
                big = big.next;
            }
            curr = curr.next;
        }
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}