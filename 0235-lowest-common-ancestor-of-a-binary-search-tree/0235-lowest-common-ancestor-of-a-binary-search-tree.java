/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {// tc is O(H) and sc is O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int curr = root.val;
        // towards right
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // towards left
        if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // if splliting in the root itself means
        return root;
    }
}