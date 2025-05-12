/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // tc is O(n) and sc is O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // step1: convert an tree into graph thing
         Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph); 
         List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(target);
        visited.add(target);
        int currentLevel = 0;

        // Step 2: BFS from target node
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentLevel == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                for (TreeNode neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            currentLevel++;
        }

        return result;
    }

     // Helper to build bidirectional graph from tree
private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
            if (parent != null) {
                graph.get(node).add(parent);
                graph.get(parent).add(node);
            }
            buildGraph(node.left, node, graph);
            buildGraph(node.right, node, graph);
        }
    }
}