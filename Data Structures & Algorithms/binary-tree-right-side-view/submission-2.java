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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root, 0);

        return result;
    }

    private void dfs(List<Integer> list, TreeNode root, int depth) {
        if (root == null) return;

        if (depth == list.size()) {
            list.add(root.val);
        }

        dfs(list, root.right, depth + 1);
        dfs(list, root.left, depth + 1);
    }
}
