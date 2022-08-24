import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int index;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int index) { this.index = index; }
 * TreeNode(int index, TreeNode left, TreeNode right) {
 * this.index = index;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Leet0199 {
    int depth = 0;
    TreeNode[] depthTreeNodeMapping = new TreeNode[105];
    public List<Integer> rightSideView(TreeNode root) {
        depth = 0;
        Arrays.fill(depthTreeNodeMapping, null);
        dfs(root);
        List<Integer> result = new ArrayList<>(100);
        for (TreeNode treeNode : depthTreeNodeMapping) {
            if (treeNode == null) {
                break;
            }

            result.add(treeNode.val);
        }

        return result;

    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }


        depth++;
        dfs(root.left);
        depth--;

        depthTreeNodeMapping[depth] = root;

        depth++;
        dfs(root.right);
        depth--;
    }

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
}
