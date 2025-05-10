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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewHelper(root,0,result);
        return result;
    }
    private void rightViewHelper(TreeNode node, int level, List<Integer> result){
        if(node == null) return;

        // if the  level & result size will be same means add to result
        if(level == result.size()){
            result.add(node.val);
        }
        // check for the right side
        rightViewHelper(node.right,level+1,result);
        // check for the left side
        rightViewHelper(node.left,level+1,result);
    }
}