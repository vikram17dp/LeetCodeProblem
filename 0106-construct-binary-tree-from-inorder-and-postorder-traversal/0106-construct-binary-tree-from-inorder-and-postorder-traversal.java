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
    private int postIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // step1: push into an hashmap
        postIndex = postorder.length - 1;
        for(int i = 0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        // step2: Recursively build the tree
        return buildSubTree(postorder,0,inorder.length-1);
    }

    private TreeNode buildSubTree(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // step3: Get the root value from the postorder array
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        //step4: Find the index of the root in inorder
        int rootIndex = inorderMap.get(rootVal);

        //step5: Important: build right subtree first, then left
        root.right = buildSubTree(postorder, rootIndex + 1, inEnd);
        root.left = buildSubTree(postorder, inStart, rootIndex - 1);

        return root;
    }
}