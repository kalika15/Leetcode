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
    int pre=0;
    public TreeNode Construct(int[] preorder, HashMap<Integer,Integer> map, int left, int right){
        if(left>right) return null;
        int val=preorder[pre];
        int in=map.get(val);    
        pre++;
        TreeNode node=new TreeNode(val);
        node.left=Construct(preorder, map, left, in-1);
        node.right=Construct(preorder, map, in+1, right);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return Construct(preorder, map, 0, inorder.length-1);
    }
}