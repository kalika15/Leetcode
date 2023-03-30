class Solution {
    Map<TreeNode, Integer> f1tbl, f2tbl, f3tbl;

    public int minCameraCover(TreeNode root) {
        f1tbl = new HashMap<>();
        f2tbl = new HashMap<>();
        f3tbl = new HashMap<>();

        return f1(root);
    }

    public int f1(TreeNode root) {
        if (root == null) return 0;
        if (f1tbl.containsKey(root)) return f1tbl.get(root);

        int with = 1 + f2(root.left) + f2(root.right);
        int without1 = Integer.MAX_VALUE;
        int without2 = Integer.MAX_VALUE;
        if (root.left != null) without1 = f3(root.left) + f1(root.right);
        if (root.right != null) without2 = f1(root.left) + f3(root.right);
        int without = Math.min(without1, without2);

        int ans = Math.min(with, without);
        f1tbl.put(root, ans);
        return ans;
    }

    public int f2(TreeNode root) {
        if (root == null) return 0;
        if (f2tbl.containsKey(root)) return f2tbl.get(root);

        int with = 1 + f2(root.left) + f2(root.right);
        int without = f1(root.left) + f1(root.right);

        int ans = Math.min(with, without);
        f2tbl.put(root, ans);
        return ans;
    }

    public int f3(TreeNode root) {
        if (root == null) return 0;
        if (f3tbl.containsKey(root)) return f3tbl.get(root);

        int ans = 1 + f2(root.left) + f2(root.right);
        f3tbl.put(root, ans);
        return ans;
    }
}
