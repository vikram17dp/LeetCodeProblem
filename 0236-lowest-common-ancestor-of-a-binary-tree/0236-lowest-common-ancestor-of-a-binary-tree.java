/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {// tc is O(N) and sc is O(H)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left,p,q);
        TreeNode rightLCA = lowestCommonAncestor(root.right,p,q);

        if(leftLCA != null && rightLCA != null){// if both are not null means return root
            return root;
        }
// if left is null return right,if right is null return left
        return (leftLCA != null) ? leftLCA: rightLCA;
    }
}