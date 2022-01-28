package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Leet1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>(300);
        int v = 1;
        int index = 0;
        while (index < Math.min(n, target.length)){
            if(target[index] == v){
                result.add("Push");
                result.add("Pop");
                index++;
            }else {
                result.add("Push");
            }
            v++;
        }

        return result;
    }
}
