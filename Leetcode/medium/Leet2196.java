import java.util.HashSet;
import java.util.Set;

public class Leet2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodes = new TreeNode[1000010];

        Set<TreeNode> noParents = new HashSet<>();

        for (int[] desc: descriptions){
            int parent = desc[0], child = desc[1], isLeft = desc[2];
            if(nodes[parent] == null){
                nodes[parent] = new TreeNode(parent);
                noParents.add(nodes[parent]);
            }

            if(nodes[child] == null){
                nodes[child] = new TreeNode(child);
            }

            if(isLeft == 0){
                nodes[parent].left = nodes[child];
                noParents.remove(nodes[child]);
            }else {
                nodes[parent].right = nodes[child];
                noParents.remove(nodes[child]);
            }
        }

        return (TreeNode) noParents.toArray()[0];
    }
}
