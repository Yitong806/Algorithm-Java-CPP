import java.util.HashMap;
import java.util.Map;

public class Leet2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> alphabetMap = buildAlphabetMap(key);
        return decode(alphabetMap, message);
    }

    private Map<Character, Character> buildAlphabetMap(String key){
        char currentValue = 'a';
        Map<Character, Character> map = new HashMap<>();

        for (char c: key.toCharArray()){
            if(Character.isLowerCase(c) && !map.containsKey(c)){
                map.put(c, currentValue);
                currentValue++;
            }
        }

        map.put(' ', ' ');

        return map;
    }

    private String decode(Map<Character, Character> alphabetMap, String message){
        StringBuilder b = new StringBuilder();
        for (char c: message.toCharArray()){
            b.append(alphabetMap.get(c));
        }

        return b.toString();
    }
}
