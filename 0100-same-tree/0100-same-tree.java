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
class Solution { // tc is O(N) and sc is O(H)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base cases

         if(p == null &&  q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
       
    }
}