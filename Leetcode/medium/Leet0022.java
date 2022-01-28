package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet0022 {
    private int leftBracketLeft = 0;
    private int rightCountLeft = 0;
    private final Stack<Character> bracketStack = new Stack<>();
    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.leftBracketLeft = n;
        this.rightCountLeft = n;
        dfs();
        return result;
    }

    private void dfs() {
        if (bracketStack.isEmpty()) {
            bracketStack.push('(');
            leftBracketLeft--;
            dfs();
            leftBracketLeft++;
            return;
        }

        if (leftBracketLeft == 0) {
            int restRight = rightCountLeft;
            StringBuilder b = new StringBuilder();
            for (char c : bracketStack) {
                b.append(c);
            }

            while (restRight-- > 0) {
                b.append(')');
            }

            result.add(b.toString());
            return;
        }
        bracketStack.push('(');
        leftBracketLeft--;
        dfs();
        leftBracketLeft++;
        bracketStack.pop();

        if (leftBracketLeft < rightCountLeft) {
            bracketStack.push(')');
            rightCountLeft--;
            dfs();
            rightCountLeft++;
            bracketStack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leet0022().generateParenthesis(3));
    }
}
