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
class Solution {// sc is O(N) and sc is O(N/K)
    public ListNode reverseKGroup(ListNode head, int k) {
        // step1: check if k least element is their or not
        ListNode temp = head;
        for(int i = 0;i<k;i++){
            if(temp == null) return head;
            temp = temp.next;
        }

        // step2: reverse first k least nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
            count++;  
        }
        // step3: Recur for the remaining list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return new head
        return prev;
    }
}