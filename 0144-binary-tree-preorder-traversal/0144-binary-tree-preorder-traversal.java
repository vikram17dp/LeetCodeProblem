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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);

            // first we have to move right side from the top angle i.e left 
            if(current.right != null){
                stack.push(current.right);
            }
             if(current.left != null){
                stack.push(current.left);
            }
        }
        return result;
    }
}