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
    public ListNode reverseList(ListNode head) {
//         Stack<Integer> st = new Stack<>();
//         // step1
//         ListNode temp = head;
//         while(temp != null){
//             st.push(temp.val);
//             temp = temp.next;
//         }
        
//         // step 2
//         temp = head;
//         while(temp != null){
//             temp.val=st.pop();
//             temp = temp.next;
//         }
//     return head;
        
        
        // Iterative manner and TC is O(n) and SC is O(n)
        // ListNode temp = head;
        // ListNode prev = null;
        // while(temp != null){
        //     ListNode front = temp.next;
        //     temp.next = prev; // this is the condition like changing the reverse
        //     prev = temp;
        //     temp = front;
        // }
        // return prev;
        
        
        // Recursive manner and TC is O(n) and SC is O(n)
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    
}