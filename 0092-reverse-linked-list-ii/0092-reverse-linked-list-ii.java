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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPre = dummy;
        ListNode currNode = head;
        // iterate upto left-1
        for(int i = 0;i<left-1;i++){
            leftPre = leftPre.next;
            currNode = currNode.next;
        }
        ListNode subListHead = currNode;
        ListNode preNode = null;
        // iterate upto right-left + 1 or <=right-left
        for(int i = 0;i<=right-left;i++){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        // join the pieces of the ll which is already reversed
        leftPre.next = preNode;
        subListHead.next = currNode;
        return dummy.next;
    }
}