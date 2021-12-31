package leetcode.medium;

public class Leet1306 {
    public boolean[] hasReached;

    public boolean canReach(int[] arr, int start) {
        hasReached = new boolean[arr.length];
        return bfs(arr, start);
    }

    private boolean bfs(int[] arr, int start) {
        if (hasReached[start]) {
            return false;
        }
        hasReached[start] = true;

        if (arr[start] == 0) {
            return true;
        }

        boolean isOK = false;
        int left = start - arr[start], right = start + arr[start];

        if (0 <= left && left < arr.length && !hasReached[left]) {
            isOK = bfs(arr, left);
        }

        if (0 <= right && right < arr.length && !hasReached[right]) {
            isOK |= bfs(arr, start + arr[start]);
        }

        return isOK;
    }
}
