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
class Solution { // tc is O(N) and sc is O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0;i<levelSize;i++){
                TreeNode node = queue.poll();

                if(leftToRight){
                    level.addLast(node.val); // left to right
                }else{
                    level.addFirst(node.val);// right to left
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight; // toggle direction
        }
        return result;
    }
}