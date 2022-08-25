public class Leet0917 {
    public String reverseOnlyLetters(String s) {
        char[] reversed = new char[s.length()];
        int left = 0, right = s.length() - 1;

        while (left <= right){
            while (left < right && !Character.isLetter(s.charAt(left))){
                reversed[left] = s.charAt(left);
                left++;
            }

            while (left < right && !Character.isLetter(s.charAt(right))){
                reversed[right] = s.charAt(right);
                right--;
            }

            reversed[left] = s.charAt(right);
            reversed[right] = s.charAt(left);
            left++;
            right--;

        }

        return new String(reversed);

    }
}
