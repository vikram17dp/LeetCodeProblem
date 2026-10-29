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
class Solution { // tc is O(N sqaure) and sc is O(H)
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null ) return 0;
        return countFrom(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    private int countFrom(TreeNode node,long targetSum){
        if(node == null) return 0;
        int count = 0;

        if(node.val == targetSum){
            count++; 
        }
        count += countFrom(node.left,targetSum-node.val);
        count += countFrom(node.right,targetSum-node.val);
        return count;
    }
}