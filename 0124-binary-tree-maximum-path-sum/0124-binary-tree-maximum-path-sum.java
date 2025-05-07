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
class Solution { // tc is O(N) and SC is O(H)
     private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node){
        if(node == null) return 0;

        int leftSum = Math.max(maxGain(node.left),0);
        int rightSum = Math.max(maxGain(node.right),0);

         // Max path sum WITH the current node as the highest node
        int currentPathSum = node.val + leftSum + rightSum;

        maxSum = Math.max(maxSum,currentPathSum);

        return node.val + Math.max(leftSum,rightSum);

    }
}