import java.util.*;

public class Leet1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
        Map<TreeNode, Integer> treeNodeLevelMapping = new HashMap<>();

        treeNodeLevelMapping.put(root, 0);
        levelMap.put(treeNodeLevelMapping.get(root), Collections.singletonList(root));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();

            if(poll.left != null){
                treeNodeLevelMapping.put(poll.left, treeNodeLevelMapping.get(poll) + 1);
                levelMap.putIfAbsent(treeNodeLevelMapping.get(poll) +1, new ArrayList<>());
                levelMap.get(treeNodeLevelMapping.get(poll) + 1).add(poll.left);

                queue.offer(poll.left);
            }

            if(poll.right != null){
                treeNodeLevelMapping.put(poll.right, treeNodeLevelMapping.get(poll) + 1);
                levelMap.putIfAbsent(treeNodeLevelMapping.get(poll) +1, new ArrayList<>());
                levelMap.get(treeNodeLevelMapping.get(poll) + 1).add(poll.right);

                queue.offer(poll.right);
            }
        }

        for (int levelNumber: levelMap.keySet()){
            if(levelNumber % 2 == 0){
                int prev = -1;
                for (TreeNode node: levelMap.get(levelNumber)){
                    System.out.print(node.val+" ");
                    if(node.val <= prev || node.val % 2 != 1){
                        return false;
                    }
                    prev = node.val;
                }
            }else {
                int prev = 999999999;
                for (TreeNode node: levelMap.get(levelNumber)){
                    System.out.print(node.val+" ");
                    if(node.val >= prev || node.val % 2 != 0){
                        return false;
                    }
                    prev = node.val;
                }
            }
        }

        return true;

    }
}
