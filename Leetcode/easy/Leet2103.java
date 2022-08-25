public class Leet2103 {
    public int countPoints(String rings) {
        boolean[][] colorFit = new boolean[10][3];
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';

            switch (color) {
                case 'R' -> colorFit[index][0] = true;
                case 'G' -> colorFit[index][1] = true;
                case 'B' -> colorFit[index][2] = true;
            }
        }

        int count = 0;
        for (boolean[] bs: colorFit){
            if(bs[0] && bs[1] && bs[2]){
                count++;
            }
        }

        return count;

    }
}
