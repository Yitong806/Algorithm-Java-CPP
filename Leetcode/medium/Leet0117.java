import java.util.*;

public class Leet0117 {
    public Node connect(Node root) {
        if(root != null){
            Map<Integer, List<Node>> map = new HashMap<>();
            bfs(root, map);
            connect(map);
        }

        return root;
    }

    private void bfs(Node root, Map<Integer, List<Node>> map) {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        Map<Node, Integer> depthMap = new HashMap<>();

        depthMap.put(root, 0);

        while (!q.isEmpty()) {
            Node poll = q.poll();
            map.putIfAbsent(depthMap.get(poll), new ArrayList<>());
            map.get(depthMap.get(poll)).add(poll);

            Node left = poll.left, right = poll.right;
            if (left != null) {
                q.offer(left);
                depthMap.put(left, depthMap.get(poll) + 1);
            }

            if (right != null) {
                q.offer(right);
                depthMap.put(right, depthMap.get(poll) + 1);
            }

        }

    }

    private void connect(Map<Integer, List<Node>> map) {
        for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
            List<Node> list = entry.getValue();

            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
    }
}
