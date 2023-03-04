package leetcode.medium;

public class Leet0769 {
    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == max[i]){
                answer += 1;
            }
        }

        return answer;
    }
}
