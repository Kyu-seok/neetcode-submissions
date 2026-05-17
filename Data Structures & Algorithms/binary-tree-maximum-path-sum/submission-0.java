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

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right), 0);

        int currentPath = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(leftSum, rightSum);
    }
}
