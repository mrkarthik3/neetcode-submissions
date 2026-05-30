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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        performDFS(root, values);
        return values;
    }
    public static void performDFS(TreeNode root, List<Integer> values){
        if(root == null) return;
        performDFS(root.left, values);
        performDFS(root.right, values);
        values.add(root.val);
    }
}