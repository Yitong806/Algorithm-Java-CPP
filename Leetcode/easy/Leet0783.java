package leetcode.easy;

public class Leet0783 {
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

    public int minDiffInBST(TreeNode root) {
        int rootValue = root.val;
        int leftMax = root.left == null ? -114514 : inorderTraversal(root.left, MAX);
        int rightMin = root.right == null ? 114514 : inorderTraversal(root.right, MIN);
        minDiff = Math.min(minDiff, Math.abs(rootValue - leftMax));
        minDiff = Math.min(minDiff, Math.abs(rightMin - rootValue));

        return minDiff;
    }

    private static final int MAX = 1;
    private static final int MIN = 0;
    private int minDiff = 999999999;

    public int inorderTraversal(TreeNode treeNode, int mod) {

        int rootValue = treeNode.val;
        if (treeNode.left != null) {
            int leftMax = inorderTraversal(treeNode.left, MAX);
            minDiff = Math.min(minDiff, Math.abs(rootValue - leftMax));
        }
        if (treeNode.right != null) {
            int rightMin = inorderTraversal(treeNode.right, MIN);
            minDiff = Math.min(minDiff, Math.abs(rightMin - rootValue));
        }

        if (mod == MAX) {
            return treeNode.right == null ? rootValue : inorderTraversal(treeNode.right, MAX);
        } else {
            return treeNode.left == null ? rootValue : inorderTraversal(treeNode.left, MIN);
        }
    }
}
