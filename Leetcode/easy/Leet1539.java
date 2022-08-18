public class Leet1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        int answer = k;

        while (left <= right){
            int mid = (left + right) / 2;

            if(isOK(arr, mid, k)){
                right = mid - 1;
            }else {
                left = mid + 1;
                answer = mid + 1 + k;
            }
        }

        return answer;
    }

    private boolean isOK(int[] arr, int midIndex, int k){
        int needed = arr[midIndex] - midIndex - 1;
        return needed >= k;
    }
}
