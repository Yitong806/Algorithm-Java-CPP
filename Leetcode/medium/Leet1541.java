import java.util.Stack;

public class Leet1541 {
    public static int minInsertions(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.equals("(") || s.equals(")")) {
            return 2;
        }

        if (s.equals("))") || s.equals("()")) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if(i < s.length() - 1){
                    if(s.charAt(i + 1) == ')'){
                        if(stack.isEmpty()){
                            answer+=1;
                        }else {
                            stack.pop();
                        }
                        i++;
                    }else {
                        answer += 1;
                        if(stack.isEmpty()){
                            answer+=1;
                        }else {
                            stack.pop();
                        }
                    }
                }else {
                    if(stack.isEmpty()){
                        answer += 2;
                    }else {
                        stack.pop();
                        answer += 1;
                    }
                }
            }

        }

        return answer + stack.size()*2;

    }

    public static void main(String[] args) {
        System.out.print(minInsertions("(()))"));
    }
}
