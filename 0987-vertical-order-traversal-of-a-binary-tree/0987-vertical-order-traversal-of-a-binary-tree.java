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
class Solution { // tc is O(Nlogk) and sc is O(N+H)
    static class Tuple{
        int row;
        int val;
        Tuple(int row,int val){
            this.row = row;
            this.val = val;
        }
    }
    Map<Integer,List<Tuple>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Tuple> tuples:map.values()){
            // Sort by row first, then by value
            Collections.sort(tuples, (a, b) -> {
                if (a.row == b.row) {
                    return a.val - b.val;
                }
                return a.row - b.row;
            });

            List<Integer> col = new ArrayList<>();
            for (Tuple t : tuples) {
                col.add(t.val);
            }
            result.add(col);
        }

        return result;
        }
    
    private void dfs(TreeNode node, int col, int row) {
        if (node == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Tuple(row, node.val));

        dfs(node.left, col - 1, row + 1);
        dfs(node.right, col + 1, row + 1);
    }
}