package leetcode.contest.week274;

import java.util.*;

public class Leet2127 {
    private final List<GraphNodePair> pairs = new LinkedList<>();

    /*public static void main(String[] args) {
        System.out.println(new Leet2127().maximumInvitations(new int[]{1, 0}));
    }*/

    public int maximumInvitations(int[] favorite) {
        GraphNode.maxCircleLength = 0;

        for (int i = 0; i < favorite.length; i++) {
            GraphNode.addInstance(i);
        }

        for (int i = 0; i < favorite.length; i++) {
            if (favorite[favorite[i]] == i) {
                GraphNode gn1 = GraphNode.getInstance(i);
                GraphNode gn2 = GraphNode.getInstance(favorite[i]);
                if (i < favorite[i]) {
                    pairs.add(new GraphNodePair(gn1, gn2));
                }
            } else {
                GraphNode.getInstance(favorite[i]).addBeingFavoured(i);
            }


        }

        int maxExtension2 = 0;
        //case 1:
        boolean[] visited = new boolean[favorite.length];
        for (GraphNodePair pair: pairs){
            System.out.println(pair);
            maxExtension2 += GraphNode.getInstance(pair.gn1.index).extend(visited) +
                    GraphNode.getInstance(pair.gn2.index).extend(visited);
        }

        //case 2:
        findMaxCircleLength(visited);
        int maxCircleLength = GraphNode.maxCircleLength;

        return Math.max(maxExtension2, maxCircleLength);
    }

    private boolean[] visitedThisRound = new boolean[100025];
    private void findMaxCircleLength(boolean[] visited) {
        Arrays.fill(visitedThisRound , false);

        for (int i = 0; i < visited.length; i++) {
            GraphNode.getInstance(i).searchMaxCircle(visited, visitedThisRound, 0);
        }
    }

    private static class GraphNode {
        private static int maxCircleLength;
        private final int index;
        private static final GraphNode[] instanceMap = new GraphNode[100025];
        private final List<GraphNode> beingFavoured = new LinkedList<>();

        private GraphNode(int index) {
            this.index = index;
        }

        public static void addInstance(int index) {
            if(instanceMap[index] == null){
                instanceMap[index] = new GraphNode(index);
            }else {
                instanceMap[index].beingFavoured.clear();
            }

        }

        public void addBeingFavoured(int favoured) {
            this.beingFavoured.add(instanceMap[favoured]);
        }

        public static GraphNode getInstance(int index) {
            return instanceMap[index];
        }

        public void searchMaxCircle(boolean[] visited, boolean[] visitedInRound, int currentLength) {
            if (visitedInRound[this.index]) {
                maxCircleLength = Math.max(maxCircleLength, currentLength);
            } else if (visited[this.index]) {
            } else {
                visitedInRound[this.index] = true;
                visited[this.index] = true;
                for (GraphNode bf : this.beingFavoured) {
                    bf.searchMaxCircle(visited, visitedInRound, currentLength + 1);
                }
                visitedInRound[this.index] = false;
            }
        }

        public int extend(boolean[] visited) {
            visited[this.index] = true;
            int result = 0;
            for (GraphNode bf: this.beingFavoured){
                visited[bf.index] = true;
                result = Math.max(result, bf.extend(visited));
            }
            return result + 1;
        }

        @Override
        public String toString() {
            return "GraphNode{" +
                    "index=" + index +
                    ", beingFavoured=" + beingFavoured +
                    '}';
        }
    }

    private static class GraphNodePair {
        GraphNode gn1;
        GraphNode gn2;

        public GraphNodePair(GraphNode gn1, GraphNode gn2) {
            this.gn1 = gn1;
            this.gn2 = gn2;
        }
    }
}
