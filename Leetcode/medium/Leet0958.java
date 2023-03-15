package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Leet0958 {
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

    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }

    private boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean startNoChild = false;
        while (!q.isEmpty()){
            TreeNode poll = q.poll();
            if(poll.left == null && poll.right != null){
                return false;
            }

            if(startNoChild && (poll.left != null || poll.right != null)){
                return false;
            }

            if(poll.right == null){
                startNoChild = true;
            }

            if(poll.left != null){
                q.offer(poll.left);
            }

            if(poll.right != null){
                q.offer(poll.right);
            }
        }


        return true;
    }
}
