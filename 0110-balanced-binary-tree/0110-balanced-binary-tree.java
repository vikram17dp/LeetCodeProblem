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
class Solution { // tc is O(n) and sc is o(h)
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
    private int check(TreeNode node){
        // base case
        if(node == null) return 0;

        // for left
        int left = check(node.left);
        if(left == -1) return -1;
        // for right
        int right = check(node.right);
        if(right == -1) return -1;

        if(Math.abs(left-right) > 1) return -1;
        return Math.max(left,right)+1;
    }
}