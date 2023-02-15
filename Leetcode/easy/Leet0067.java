package leetcode.easy;

public class Leet0067 {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        return array2str(addArray(str2array(a, length), str2array(b, length)));
    }



    public int[] str2array(String x, int expectedArrayLength){
        int[] array = new int[expectedArrayLength];
        for (int i = 0; i < x.length(); i++){
            array[expectedArrayLength - 1 - i] = x.charAt(x.length() - 1 - i) - '0';
        }

        return array;
    }
    public int[] addArray(int[] a1, int[] a2){
        int[] result = new int[a1.length + 1];
        int carry = 0;
        for (int i = a1.length - 1; i >= 0 || carry != 0; i--) {
            if(i < 0){
                result[0] = carry;
                carry = 0;
                break;
            }

            int sum = a1[i] + a2[i] + carry;
            result[i + 1] = sum % 2;
            carry = sum / 2;
        }

        return result;

    }
    public String array2str(int[] arr){
        StringBuilder b = new StringBuilder();
        boolean firstNon0 = false;
        for (int x: arr){
            if(x != 0){
                firstNon0 = true;
            }

            if(firstNon0){
                b.append(x);
            }

        }

        return firstNon0 ? b.toString(): "0";
    }


}
