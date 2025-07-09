/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution { // tc is O(N) and sc is O(h)
    TreeNode first = null,second = null,prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
         // Violation: current node's value is less than the previous node
        if(prev!=null && first == null && prev.val >= root.val){
            first = prev;
        }
        if(prev!= null && first != null && prev.val >= root.val){
            second = root;
        }
        prev = root;

        inorder(root.right);
    }
}