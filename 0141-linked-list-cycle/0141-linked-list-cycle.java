/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> mpp = new HashSet<>();
        while(temp!=null){
            if(mpp.contains(temp)){
                return true;
            }
            mpp.add(temp);
            temp = temp.next;
        }
        return false;
    }
}