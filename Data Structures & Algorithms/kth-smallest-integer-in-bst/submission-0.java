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
    public int kthSmallest(TreeNode root, int k) {
        // In order traversal of BST gives sorted values
        ArrayList<Integer> sortedValues = new ArrayList<>();
        inOrderTraverse(root, sortedValues);
        return sortedValues.get(k-1); // k is 1 indexed.
    }

    public static void inOrderTraverse(TreeNode root, List<Integer> values) {
        if(root == null) return;
        inOrderTraverse(root.left, values);
        values.add(root.val);
        inOrderTraverse(root.right, values);
    }
}
