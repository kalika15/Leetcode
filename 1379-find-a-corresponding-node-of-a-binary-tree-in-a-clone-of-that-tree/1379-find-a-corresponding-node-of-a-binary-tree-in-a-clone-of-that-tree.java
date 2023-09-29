/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode solve(TreeNode Original,TreeNode cloned, TreeNode Target){
        if(Original==null) return null;
        if(Original==Target) return cloned;
        TreeNode left=solve(Original.left,cloned.left, Target);
        if(left!=null) return left;
        TreeNode right=solve(Original.right,cloned.right, Target);
        if(right!=null) return right;
        return null;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        return solve(original,cloned, target);
    }
}