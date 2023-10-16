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
    // public List<TreeNode> solve(int n){
    //     if(n==1) return 1;
    //     for()
    // }
    public List<TreeNode> allPossibleFBT(int n) {
        if(n==1){ 
            List<TreeNode> result=new ArrayList<>();
            result.add(new TreeNode(0));
            return result;
        }
        if(n%2==0) return new ArrayList<>();
        List<TreeNode> all=new ArrayList<>();
        for(int k=1; k<=n-2; k+=2){
            List<TreeNode> allleft=allPossibleFBT(k);
            List<TreeNode> allright=allPossibleFBT(n-k-1);
            for(TreeNode left: allleft){
                for(TreeNode right: allright){
                    all.add(new TreeNode(0,left,right));
                }
            }
        }
        return all;
    }
}