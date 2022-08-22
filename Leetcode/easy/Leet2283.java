public class Leet2283 {
    public boolean digitCount(String num) {
        int[] counting = new int[10];

        for (char c: num.toCharArray()){
            counting[c - '0']++;
        }

        for (int i = 0, length = num.length(); i < length; i++){
            if(counting[i] != num.charAt(i) - '0'){
                return false;
            }
        }

        return true;
    }
}
