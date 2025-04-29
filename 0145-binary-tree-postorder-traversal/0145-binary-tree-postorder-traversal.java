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
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) return result;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            // Add to the front (reverses the process of preorder)
            result.addFirst(current.val);

            // Left is pushed second so it's processed after right

            if(current.left != null){
                stack.push(current.left);
            }

            if(current.right != null){
                stack.push(current.right);
            }

        }
        return result;
    }
   
}