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
class Solution {// tc is o(N) and sc is O(N) using an hashset but we can optimize the space using an bst iterator we can get an Tc is O(N) and sc is O(1)
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root,k,set);
    }
    private boolean dfs(TreeNode node,int k,Set<Integer> set){
        if(node == null) return false;

        if(set.contains(k-node.val)) return true;
        set.add(node.val);
        return dfs(node.left,k,set) || dfs(node.right,k,set);


    }
}