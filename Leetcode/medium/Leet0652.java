package leetcode.medium;

import leetcode.easy.Leet0104;

import java.util.*;

public class Leet0652 {
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

    private final Map<String, Integer> table = new HashMap<>();
    private final List<TreeNode> answer = new ArrayList<>();

    private void clear() {
        table.clear();
        answer.clear();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        clear();
        dfs(root);
        return answer;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = "L" + dfs(root.left) + root.val + dfs(root.right) + "R";
        table.putIfAbsent(result, 0);
        table.put(result, table.get(result) + 1);
        if (table.get(result) == 2) {
            answer.add(root);
        }

        return result;
    }
}
