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
class Solution {// TC is O(n+m) and SC is O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Create a dummy node to simplify list management
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = returnNode;
        
        // Merge both lists while neither is empty
        while (list1 != null && list2 != null) {
            
            if (list1.val <= list2.val) {
                returnNode.next = list1; // Append the smaller node
                list1 = list1.next; // Advance list1
            } else {
                returnNode.next = list2; // Append the smaller node
                list2 = list2.next; // Advance list2
            }
            returnNode = returnNode.next; // Advance the merged list pointer
        }
        
        // Append any remaining nodes in list1 or list2
        if (list1 != null) {
            returnNode.next = list1;
        } else if (list2 != null) {
            returnNode.next = list2;
        }
        
        return headNode.next; // Return the merged list (skip dummy node)
    }
}
