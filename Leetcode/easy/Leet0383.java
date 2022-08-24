public class Leet0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteAlphabet = collectAlphabet(ransomNote);
        int[] magazineAlphabet = collectAlphabet(magazine);
        return compare(ransomNoteAlphabet, magazineAlphabet);
    }

    private int[] collectAlphabet(String s){
        int[] alphabet = new int[26];
        final int length = s.length();
        for(int i = 0;  i< length;i++){
            alphabet[s.charAt(i) - 'a']++;
        }

        return alphabet;
    }

    private boolean compare(int[] small, int[] large){
        final int length = small.length;
        for (int i = 0; i < length; i++) {
            if(small[i] > large[i]){
                return false;
            }
        }

        return true;
    }
}
