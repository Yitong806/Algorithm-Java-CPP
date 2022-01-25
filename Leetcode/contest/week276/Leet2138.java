package leetcode.contest.week276;

public class Leet2138 {
    public String[] divideString(String s, int k, char fill) {
        int groups = (int)(Math.ceil(s.length() * 1.0 / k));
        String[] result = new String[groups];

        for (int i = 0; i < groups; i++) {
            if(i != groups - 1){
                result[i] = s.substring(i * k, i*k + k);
            }else {
                StringBuilder b = new StringBuilder(s.substring(i * k));
                while (b.length() < k){
                    b.append(fill);
                }
                result[i] = b.toString();
            }
        }
        return result;
    }
}
