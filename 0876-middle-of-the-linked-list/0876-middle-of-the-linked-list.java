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
class Solution { // TC is O(n+n/2) and sc is O(1)
    public ListNode middleNode(ListNode head) {
        // method one
//         int count = 0;
//         ListNode temp = head;
//         // step 1
//         while(temp != null){
//             count++;
//             temp = temp.next;
//         }
//         // step 2
        
//         int middleNode = (count/2)+1;
//         temp = head;
//         while(temp != null){
            
//             middleNode = middleNode -1;
//             if(middleNode == 0) break;
//             temp = temp.next;
//         }
//         return temp;
        
        // method two with slow and fast
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
        
    }
}