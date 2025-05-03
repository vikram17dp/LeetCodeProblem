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
class Solution { // tc is O(nlogk) and sc is O(n)
    public ListNode
 mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        // Step 1: Add the head node of each list to the min-heap
        for(ListNode node:lists){
            if(node!=null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // step2: While heap is not empty, pop the smallest node and add to result list
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If there's more in this list, add the next node to the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}