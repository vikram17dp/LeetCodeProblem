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
    public ListNode sortList(ListNode head) { // tc is O(nlogn) and sc is O(1)
        // edge case
        if (head == null || head.next == null)
            return head;

        // finding the middle of ll

        ListNode middle = middleList(head);

        ListNode leftHead = head, rightHead = middle.next;

        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoList(leftHead, rightHead);

    }

    private ListNode middleList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // if any one item left

        // if (l1 != null)
        //     current.next = l1;

        // if (l2 != null)
        //     current.next = l2;
        
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}