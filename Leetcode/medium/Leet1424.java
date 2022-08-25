import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leet1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Tuple> tuples = buildTuple(nums);
        tuples.sort(comparator());
        return diagonalOrder(tuples);
    }

    private List<Tuple> buildTuple(List<List<Integer>> nums) {

        List<Tuple> tuples = new ArrayList<>(100010);
        for (int i = 0, size = nums.size(); i < size; i++) {
            for (int j = 0, size_i = nums.get(i).size(); j < size_i; j++) {
                tuples.add(new Tuple(i, j, nums.get(i).get(j)));
            }
        }

        return tuples;

    }

    private Comparator<Tuple> comparator(){
        return (o1, o2) -> {
            int sum1 = o1.x + o1.y, sum2 = o2.x + o2.y;
            if(sum1 != sum2){
                return Integer.compare(sum1, sum2);
            }else {
                return Integer.compare(o2.x, o1.x);
            }
        };
    }

    private int[] diagonalOrder(List<Tuple> tuples){
        int[] result = new int[tuples.size()];
        for (int i = 0; i < tuples.size(); i++){
            result[i] = tuples.get(i).value;
        }

        return result;
    }

    private static class Tuple {
        int x;
        int y;
        int value;

        public Tuple(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
