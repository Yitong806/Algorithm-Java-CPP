package leetcode.easy;

import leetcode.medium.Leet1350;

public class Leet0104 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maximumDepth = 0;

    public int maxDepth(TreeNode root) {
        setMaxDepthByDFS(root, 0);
        return maximumDepth;
    }

    public void setMaxDepthByDFS(TreeNode root, int currentDepth){
        if(root == null){
            return;
        }

        maximumDepth = Math.max(maximumDepth, currentDepth + 1);
        setMaxDepthByDFS(root.left, currentDepth + 1);
        setMaxDepthByDFS(root.right, currentDepth + 1);
    }
}
