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
    public int averageOfSubtree(TreeNode root) {
        int[] res=new int[1];
        solve(root, res);
        return res[0];
    }
    public int[] solve(TreeNode root ,  int[] res){
        if(root==null) return new int[]{0,0};
        int[] left=solve(root.left,res);
        int[] right=solve(root.right, res);
        int curr=root.val +left[0]+right[0];
        int count=1+left[1]+right[1];
        if(curr/count == root.val) res[0]++;
        return new int[]{curr, count};
    }
}