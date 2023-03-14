package leetcode.medium;

public class Leet0129 {
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

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private int sum;

    private void dfs(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += currentSum * 10 + root.val;
            return;
        }

        if(root.left != null){
            dfs(root.left, currentSum* 10 + root.val);
        }

        if(root.right != null){
            dfs(root.right, currentSum*10 + root.val);
        }

    }
}
