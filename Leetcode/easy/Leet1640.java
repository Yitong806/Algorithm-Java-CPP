import java.util.*;

public class Leet1640 {
    private Set<Integer> asSet(int[] arr){
        Set<Integer> s = new HashSet<>();
        for (int i : arr){
            s.add(i);
        }

        return s;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {

        if(pieces.length == 1){
            if(arr.length != pieces[0].length) {
                return false;
            }

            return asSet(arr).equals(asSet(pieces[0]))
                    && arr[0] == pieces[0][0]
                    && arr[arr.length - 1] == pieces[0][pieces[0].length - 1];

        }

        Map<Integer, Integer> arrValueIndexMapping = new HashMap<>();
        List<Integer> startingValues = new ArrayList<>(), endingValues = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arrValueIndexMapping.put(arr[i], i);
        }

        for (int[] p: pieces){
            startingValues.add(p[0]);
            endingValues.add(p[p.length - 1]);
        }

        int endingFail = 0, startingFail = 0;

        for (int i = 0; i < startingValues.size(); i++){
            int startValue = startingValues.get(i), endValue = endingValues.get(i);

            Integer startIndex = arrValueIndexMapping.get(startValue), endIndex = arrValueIndexMapping.get(endValue);
            if(startIndex == null ||endIndex == null){
                return false;
            }

            if(startIndex > 0 && !endingValues.contains(arr[startIndex - 1])){
                endingFail++;
            }

            if(endIndex < startingValues.size() - 1 && !startingValues.contains(arr[endIndex + 1])){
                startingFail++;
            }
        }


        return endingFail == 0 && startingFail == 0;

    }
}
