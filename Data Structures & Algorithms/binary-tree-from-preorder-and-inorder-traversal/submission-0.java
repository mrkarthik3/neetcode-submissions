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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int midIdx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(rootVal == inorder[i]) midIdx = i;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, midIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder, midIdx+1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length+1, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
