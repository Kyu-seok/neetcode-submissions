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
 /*
    Constraints:
    
    1 <= The number of nodes in the tree <= 10000.
    -1000000000 <= Node.val <= 1000000000
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;

        return (minValue < root.val && root.val < maxValue)
            && dfs(root.left, minValue, root.val)
            && dfs(root.right, root.val, maxValue);
    }


}
