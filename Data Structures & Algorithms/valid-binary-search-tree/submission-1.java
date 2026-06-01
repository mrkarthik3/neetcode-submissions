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
    public boolean isValidBST(TreeNode root) {
        // Structy.net approach.
        // Inorder traversal in BST gives => sorted list
        List<Integer> values = new ArrayList<>();
        traverseInOrder(root, values);
        for(int i = 0; i < values.size()-1; i++) {
            if(values.get(i) >= values.get(i+1)) return false;
        }
        return true;
    }
    public static void traverseInOrder(TreeNode root, List<Integer> values){
        if(root == null) return;
        traverseInOrder(root.left, values);
        values.add(root.val);
        traverseInOrder(root.right, values);
    }
}
