package leetcode.medium;

import java.util.*;

public class Leet0199 {

    private int currentDepth;
    private final List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        if(result.size() < currentDepth + 1){
            result.add(root.val);
        }else {
            result.set(currentDepth, root.val);
        }
        currentDepth += 1;
        dfs(root.left);
        dfs(root.right);
        currentDepth -= 1;
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
