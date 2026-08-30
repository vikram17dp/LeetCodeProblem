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
class Solution { // tc is O(4n)=>o(n) and sc is O(1)
    public ListNode removeNodes(ListNode head) {
        // step1: reverse the linkded list
        head = reverse(head); // tc is O(n)
        // step2: keep travese from right to left
        int maxValue = 0;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){ // tc is O(n)
            if(curr.val < maxValue){
                prev.next = curr.next;// skip the smaller value to its right
            }else{
                maxValue = curr.val;
                prev = curr;
            }
            curr = curr.next;
        }
        // step3: reverse the result too
        return reverse(head); // tc is O(n)
    }
    public ListNode reverse(ListNode head){// tc is o(n)
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode front = curr.next;

            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
}