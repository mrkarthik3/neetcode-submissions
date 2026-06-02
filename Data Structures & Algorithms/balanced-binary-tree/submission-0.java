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
    public boolean isBalanced(TreeNode root) {
        // returning -1 => imbalance is present
        // Anything other than -1 => tree is balanced
        return checkBalance(root) > -1;
    }
    public static int checkBalance(TreeNode root) {
        // returning -1 => imbalance is present
        if(root == null) return 0;

        int left = checkBalance(root.left);
        if(left == -1) return -1;
        int right = checkBalance(root.right);
        if(right == -1) return -1;

        if(Math.abs(left-right) > 1) {
            return -1;
        }

        return 1 + Math.max(left,right);
    }
}
