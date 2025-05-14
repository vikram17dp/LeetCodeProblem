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
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // step1:Store inorder values with their indices for O(1) lookup
        for(int i = 0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        // Step 2:Recursively build the tree
        return build(preorder,0,inorder.length-1);

    }
    private TreeNode build(int[] preorder,int inStart,int inEnd){
        // base case
        if(inStart > inEnd) return null;

        // Step 3:Pick root value from preorder using preorderIndex
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

         // Step 4:Get the index of root in inorder
        int rootIndex = inorderMap.get(rootVal);

        // step5: Recursively construct left and right subtrees
        root.left = build(preorder, inStart, rootIndex - 1);
        root.right = build(preorder, rootIndex + 1, inEnd);

        return root;
    }
}