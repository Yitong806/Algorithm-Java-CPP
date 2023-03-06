package leetcode.easy;

public class Leet1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        int ans = -100;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (accept(arr, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            ans = left + k;
        }

        return ans;



    }

    public boolean accept(int[] arr, int k, int mid) {
        return arr[mid] - mid > k;
    }
}
