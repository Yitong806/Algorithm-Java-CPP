import java.util.Arrays;

public class Leet0279 {
    public int numSquares(int n) {

        int[] squares = new int[101];

        for (int i = 0; i < 101; i++) {
            squares[i] = i * i;
        }

        if(in(squares, n)){
            return 1;
        }

        for(int sq: squares){
            if(in(squares, n - sq)){
                return 2;
            }
        }

        for (int sq1: squares){
            for(int sq2: squares){
                if(in(squares, n - sq1 - sq2)){
                    return 3;
                }
            }
        }


        return 4;
    }

    private boolean in(int[] squares, int n){

        for (int sq: squares){
            if(n == sq){
                return true;
            }
        }

        return false;
    }
}
