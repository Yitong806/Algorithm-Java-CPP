public class Leet0304 {
    private static class NumMatrix {

        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            final int a = matrix.length, b = matrix[0].length;

            prefixSum = new int[a][b];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {

                    if(i == 0){
                        if(j == 0){
                            prefixSum[i][j] = matrix[i][j];
                        } else{
                            prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
                        }
                    }else {
                        if(j == 0){
                            prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j];
                        }else {
                            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i][j];
                        }
                    }

                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(row1 == 0){
                if(col1 == 0){
                    return prefixSum[row2][col2];
                }else {
                    return prefixSum[row2][col2] - prefixSum[row2][col1 - 1];
                }
            }else {
                if(col1 == 0){
                    return prefixSum[row2][col2] - prefixSum[row1 - 1][col2];
                }else {
                    int sum = prefixSum[row2][col1 - 1] + prefixSum[row1 - 1][col2] - prefixSum[row1 - 1][col1 - 1];
                    return prefixSum[row2][col2] - sum;
                }
            }
        }
    }
}
