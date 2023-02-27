package leetcode.medium;

public class Leet0427 {

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    public boolean allValuesSame(int[][] grid, int startX, int endX, int startY, int endY){
        int firstValue = grid[startX][startY];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if(grid[i][j] != firstValue){
                    return false;
                }
            }
        }

        return true;
    }

    public Node construct(int[][] grid, int startX, int endX, int startY, int endY){
        if(allValuesSame(grid, startX, endX, startY, endY)){
            return new Node(grid[startX][startY] == 1, true);
        }
        int midX = (startX + endX) / 2, midY = (startY + endY) / 2;

        Node n = new Node(true, false);
        n.topLeft = construct(grid, startX, midX, startY, midY);
        n.topRight = construct(grid, startX, midX, midY + 1, endY);
        n.bottomLeft = construct(grid, midX + 1, endX, startY, midY);
        n.bottomRight = construct(grid, midX + 1, endX, midY + 1, endY);

        return n;
    }
}
