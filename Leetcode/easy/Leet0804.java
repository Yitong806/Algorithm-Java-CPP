import java.util.HashSet;
import java.util.Set;

public class Leet0804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> result = new HashSet<>();

        StringBuilder b = new StringBuilder();
        for (String w : words) {
            b.setLength(0);
            for (char c : w.toCharArray()) {
                b.append(map[c - 'a']);
            }
            result.add(b.toString());
        }

        return result.size();
    }
}
