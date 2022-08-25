public class Leet1306 {

    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        if(!check0Exist(arr)){
            return false;
        }

        visited = new boolean[arr.length];
        visited[start] = true;

        return dfs(arr, start);

    }

    private boolean check0Exist(int[] arr){
        for(int a: arr){
            if(a == 0){
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int[] arr, int current) {

        if(arr[current] == 0){
            visited[current] = true;
            return true;
        }

        visited[current] = true;
        int left = current - arr[current], right = current + arr[current];
        if(left >= 0 && !visited[left]){
            if(dfs(arr, left)){
                return true;
            }
        }

        if(right <= arr.length - 1 && !visited[right]){
            if(dfs(arr, right)){
                return false;
            }
        }

        visited[current] = false;
        return false;

    }
}
