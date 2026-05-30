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
        // Structy.net approach - better than neetcode
        List<List<Integer>> levels = new ArrayList<>();
        traverse(root, 0, levels);
        List<Integer> rightView = new ArrayList<>();
        for(List<Integer> level : levels) {
            rightView.add(level.get(level.size()-1));
        }
        return rightView;
    }

    public static void traverse(TreeNode root, int levelNum, List<List<Integer>> levels) {
        if(root == null) return;
        
        if(levelNum == levels.size()) {
            List<Integer> level = new ArrayList<>(List.of(root.val));
            levels.add(level);
        } else {
            levels.get(levelNum).add(root.val);
        }

        traverse(root.left, levelNum+1, levels);
        traverse(root.right, levelNum+1, levels);
    }
}
