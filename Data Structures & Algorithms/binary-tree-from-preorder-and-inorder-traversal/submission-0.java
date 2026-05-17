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
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, 0, inorder.length);
    }

    private TreeNode buildTree(int preIndex, int inStart, int inEnd) {
        if (preIndex >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = map.get(root.val);
        int leftSize = rootIndex - inStart;

        root.left = buildTree(preIndex + 1, inStart, rootIndex - 1);
        root.right = buildTree(preIndex + leftSize + 1, rootIndex + 1, inEnd);

        return root;
    }
}
