import java.util.*;

public class Leet0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>(2000);
        for (int i = 0; i < 2000; i++) {
            result.add(new ArrayList<>());
        }

        bfs(root, result);

        List<List<Integer>> finalResult = new ArrayList<>(2000);
        for (List<Integer> l: result){
            if(l.isEmpty()){
                break;
            }

            finalResult.add(l);
        }

        return finalResult;
    }

    private void bfs(TreeNode root, List<List<Integer>> result){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> treeNodeDepthMapping = new HashMap<>();

        queue.offer(root);
        treeNodeDepthMapping.put(root, 0);

        while (!queue.isEmpty()){
            TreeNode first = queue.poll();

            int depth = treeNodeDepthMapping.get(first);
            result.get(depth).add(first.val);

            if(first.left != null){
                treeNodeDepthMapping.put(first.left, depth+1);
                queue.offer(first.left);
            }

            if(first.right != null){
                treeNodeDepthMapping.put(first.right, depth + 1);
                queue.offer(first.right);
            }
        }
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
