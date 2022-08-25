public class Leet2351 {
    public char repeatedCharacter(String s) {
        boolean[] ap = new boolean[26];
        for (char c: s.toCharArray()){
            if(ap[c-'a']){
                return c;
            }

            ap[c-'a'] = true;
        }

        return '\0';
    }
}
