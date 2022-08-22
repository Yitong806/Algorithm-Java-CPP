public class Leet2038 {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0, bobMoves = 0;
        for (int i = 0; i < colors.length();) {
            boolean forward = true;
            char currentChar = colors.charAt(i);
            int consecutive = 0;
            while (i < colors.length() && colors.charAt(i) == currentChar) {
                i++;
                forward = false;
                consecutive++;
            }

            if(forward){
                i++;
            }

            if(currentChar == 'A'){
                aliceMoves += Math.max(0, consecutive - 2);
            }else {
                bobMoves += Math.max(0, consecutive - 2);
            }
        }

        return aliceMoves > bobMoves;
    }
}
