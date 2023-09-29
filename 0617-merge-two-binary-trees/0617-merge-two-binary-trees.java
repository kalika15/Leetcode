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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        else if(root1!=null && root2!=null){
            return new TreeNode(root1.val+root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
        }
        else if(root1!=null){
             return new TreeNode(root1.val+0, mergeTrees(root1.left, null), mergeTrees(root1.right, null));
        }
        else if(root2!=null){
            return new TreeNode(root2.val+0, mergeTrees(null, root2.left), mergeTrees(null,root2.right));
        }
        return null;
    }
}