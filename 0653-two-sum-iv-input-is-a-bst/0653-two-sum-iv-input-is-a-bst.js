/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) { // tc is O(N) and sc is O(N)
    const set = new Set();
    return dfs(root,k,set);
};
function dfs(node,k,set){
    if(!node) return false;
    if(set.has(k-node.val)) return true;
    set.add(node.val);
    return dfs(node.left,k,set) || dfs(node.right,k,set);
}