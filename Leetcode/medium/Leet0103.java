package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Leet0103 {

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

    private Map<Integer, List<Integer>> depthMap = new TreeMap<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        depthMap.entrySet().stream().filter(e -> e.getKey() % 2 == 1).forEach(e -> Collections.reverse(e.getValue()));
        return new ArrayList<>(depthMap.values());
    }

    public void dfs(TreeNode root, int currentDepth){
        if(root == null){
            return;
        }

        depthMap.putIfAbsent(currentDepth, new ArrayList<>());
        depthMap.get(currentDepth).add(root.val);
        dfs(root.left, currentDepth + 1);
        dfs(root.right, currentDepth + 1);
    }

}
