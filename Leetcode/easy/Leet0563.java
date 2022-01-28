package leetcode.easy;

public class Leet0563 {
    public static class TreeNode {
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

    public int sum = 0;

    public int postfixTraversal(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = postfixTraversal(root.left);
        int right = postfixTraversal(root.right);
        sum += Math.abs(left-right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        postfixTraversal(root);
        return sum;
    }
}
