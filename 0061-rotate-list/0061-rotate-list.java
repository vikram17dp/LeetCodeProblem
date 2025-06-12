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
class Solution { // tc is O(N) and sc is O(1)
    public ListNode rotateRight(ListNode head, int k) {
        // base case
        if(head == null || head.next == null || k == 0) return head;
        // step1: we have to findout an length of ll
        ListNode tail = head;
        int length = 1;
       while(tail.next != null){
            tail = tail.next;
            length++;
       }
       // step2: make the shape circluar of ll
       tail.next = head;

       // step3: find the newHead and tail
       int stepsToNewTail = length - k % length;
       ListNode newTail = head;
       for(int i = 1;i<stepsToNewTail;i++){
            newTail = newTail.next;
       }
       ListNode newHead = newTail.next; // break the cycle
       newTail.next = null;
       return newHead;
    }
}