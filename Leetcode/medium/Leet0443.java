package leetcode.medium;

public class Leet0443 {
    public int compress(char[] chars) {
        StringBuilder answer = new StringBuilder();
        char currentChar = '\0';
        int repeatNumber = 0;
        for (char c: chars){
            if(currentChar == '\0'){
                currentChar = c;
                repeatNumber = 1;
                continue;
            }

            if(currentChar != c){
                answer.append(currentChar);
                if(repeatNumber > 1){
                    answer.append(repeatNumber);
                }
                repeatNumber = 1;
                currentChar = c;
            }else {
                repeatNumber++;
            }
        }

        answer.append(currentChar);
        if(repeatNumber > 1){
            answer.append(repeatNumber);
        }

        for (int i = 0; i < answer.length(); i++) {
            chars[i] = answer.charAt(i);
        }

        return answer.length();
    }

}
