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
class Solution { // tc is O(log²(n)) and sc is  O(logn)
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = leftHeight(root);
        int right = rightHeight(root);
        // for the perfect binary tree
        if(left == right){
            return (1<<left)-1; // 2^h - 1;
        }

        // if not means just 1 + add the left and right with recursively
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int leftHeight(TreeNode node){
        int height = 0;
        while(node != null){
            height++;
            node = node.left;
        }
        return height;
    }
    private int rightHeight(TreeNode node){
        int height = 0;
        while(node != null){
            height++;
            node = node.right;
        }
        return height;
    }
}