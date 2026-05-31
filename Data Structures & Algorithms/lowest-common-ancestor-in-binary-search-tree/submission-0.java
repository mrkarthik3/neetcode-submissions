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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        // System.out.println(path2);

        HashSet<Integer> path1Set = new HashSet<>();
        for(TreeNode node : path1) {
            path1Set.add(node.val);
        }
        
        for(TreeNode node : path2) {
            if(path1Set.contains(node.val)) {
                return node;
                // first common one is the LCA
            }
        }
        return null;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode target){
        if(root == null) return null;

        if(root.val == target.val) {
            List<TreeNode> path = new ArrayList<>(List.of(target));
            return path;
        }

        List<TreeNode> nextPath;
        if(target.val < root.val) {
            nextPath = getPath(root.left, target);
        } else {
            nextPath = getPath(root.right, target);
        }

        if(nextPath != null) { // will always come here in bst
            nextPath.add(root);
            return nextPath;
        }

        return null; // will never hit anyways...
    }
}
