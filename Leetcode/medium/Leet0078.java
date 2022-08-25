import java.util.ArrayList;
import java.util.List;

public class Leet0078 {

    List<List<Integer>> answer = new ArrayList<>();

    boolean[] isSelected;

    public List<List<Integer>> subsets(int[] nums) {
        isSelected = new boolean[nums.length];
        dfs(nums, 0);

        return answer;
    }

    private void dfs(int[] nums, int currentIndex){
        if(currentIndex == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < isSelected.length; i++){
                if(isSelected[i]){
                    list.add(nums[i]);
                }
            }
            answer.add(list);

            return;
        }

        isSelected[currentIndex] = false;
        dfs(nums, currentIndex + 1);
        isSelected[currentIndex] = true;
        dfs(nums, currentIndex + 1);


    }

}
