public class Leet1668 {
    public int maxRepeating(String sequence, String word) {
        StringBuilder b = new StringBuilder(word);
        int repeat = 0;
        String string = word;
        while (sequence.contains(string)){
            repeat++;
            b.append(word);
            string = b.toString();
        }

        return repeat;
    }
}
