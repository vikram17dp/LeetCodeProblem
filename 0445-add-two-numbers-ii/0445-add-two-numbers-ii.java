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
class Solution { // tc is O(4N)=> O(N) and sc is O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        ListNode reversedl1 = reverseList(l1); // tc is O(N)
        ListNode reversedl2 = reverseList(l2); // tc is O(N)

        int carry = 0;
        while (reversedl1 != null || reversedl2 != null || carry > 0) { // tc is O(N)
            int sum = carry;
            if (reversedl1 != null) {
                sum += reversedl1.val;
                reversedl1 = reversedl1.next;
            }
            if (reversedl2 != null) {
                sum += reversedl2.val;
                reversedl2 = reversedl2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            current = current.next;

        }
        return reverseList(dummy.next); // tc is O(N)

    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
}