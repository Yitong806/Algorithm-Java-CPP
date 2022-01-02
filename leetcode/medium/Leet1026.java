package leetcode.medium;

public class Leet1026 {
    int answer = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return answer;
    }
    private void dfs(TreeNode root){
        if(root != null){
            System.out.println(root);
            int tempMax = max;
            int tempMin = min;
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
            answer = Math.max(answer, max - min);
            dfs(root.left);
            max = tempMax;
            min = tempMin;
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
            answer = Math.max(answer, max - min);
            dfs(root.right);
        }
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
