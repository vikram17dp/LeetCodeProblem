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
class Solution { // tc is O(2N) => O(N) and sc is O(2N)=> O(N)
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        // step1 : add nodes into arraylist
        ListNode curr = head;
        while(curr != null){
            values.add(curr.val);
            curr = curr.next;
        }
        // step2: create an monotonic stack
        Stack<Integer> stack = new Stack<>();
        int n = values.size();
        int[] ans = new int[n];
        // run an loop from right to left because we are doing NGE in montonoic stack
        for(int i = n -1;i>=0;i--){
            // check if any value is greater than current value means pop
            while(!stack.isEmpty() && stack.peek() <= values.get(i)){
                stack.pop();
            }
            // If stack is not empty, top is the next greater element
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }else{
                ans[i] = 0;
            }
            // pushing the values into stack
            stack.push(values.get(i));
        }
        return ans;
    }
}