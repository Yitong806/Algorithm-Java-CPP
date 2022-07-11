import java.util.ArrayList;
import java.util.List;

public class Leet1238 {
    String[] grayCode;
    public List<Integer> circularPermutation(int n, int start) {
        grayCode = new String[(int)Math.pow(2, n)];

        StringBuilder current = build0s(n);
        for (int i = 0; i < grayCode.length; i++) {
            grayCode[i] = current.toString();
            if(i % 2 == 0){
                current.setCharAt(n - 1, current.charAt(n - 1) == '0' ? '1': '0');
            }else {
                for (int j = current.length() - 1; j >= 0; j--) {
                    if(j != 0 && current.charAt(j) == '1'){
                        current.setCharAt(j - 1, current.charAt(j - 1) == '0' ? '1': '0');
                        break;
                    }
                }
            }
        }

        int[] last = new int[grayCode.length];

        for (int i = 0; i < grayCode.length; i++) {
            last[i] = Integer.parseInt(grayCode[i], 2);
        }

        int index = 0;
        for (int i = 0; i < last.length; i++) {
            if(last[i] == start){
                index = i;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < last.length; i++) {
            result.add(last[(i + index) % last.length]);
        }

        return result;

    }

    StringBuilder build0s(int n){
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            b.append('0');
        }

        return b;
    }
}
