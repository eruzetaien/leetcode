class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean zeroInFirstRow = false, zeroInFirstCol = false;

        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0){zeroInFirstCol = true;}
        }

        for (int j = 0; j < n; j++){
            if (matrix[0][j] == 0){zeroInFirstRow = true;}
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0; // Mark zero in first col
                    matrix[0][j] = 0; // Mark zero in first row
                }
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroInFirstCol){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

        if (zeroInFirstRow){
            for (int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}