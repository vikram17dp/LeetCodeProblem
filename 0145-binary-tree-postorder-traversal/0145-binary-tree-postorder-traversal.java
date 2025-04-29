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
class Solution { // tc is O(n) and sc is O(n) for arraylist and O(h) for height of tree
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }
    private void postorder(TreeNode node,List<Integer> result){
        if(node == null) return;

        postorder(node.left,result);
        postorder(node.right,result);
        result.add(node.val);
    }
}