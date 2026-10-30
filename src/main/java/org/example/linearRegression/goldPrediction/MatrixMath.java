package org.example.linearRegression.goldPrediction;

public class MatrixMath {

    public double[][] multiply(double[][] a, double[][] b) {

        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for(int k = 0 ; k < colsA; k++){
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }


    public double pointMultiply(double[] horizontal, double[] vertical) {
        if(horizontal.length != vertical.length){
            throw new IllegalArgumentException("error in pointMultiply");
        }
        double result = 0;
        for(int i = 0; i < horizontal.length; i++){
            result += horizontal[i] * vertical[i];
        }
        return result;
    }





    public double[] solveGaussJordan(double[][] matrix) {
        int n = matrix.length;

        double[][] mat = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, mat[i], 0, n + 1);
        }


        for (int i = 0; i < n; i++) {


            double pivot = mat[i][i];
            for (int j = 0; j < n + 1; j++) {
                mat[i][j] /= pivot;
            }


            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = mat[k][i];
                    for (int j = 0; j < n + 1; j++) {
                        mat[k][j] -= factor * mat[i][j];
                    }
                }
            }
        }


        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            weights[i] = mat[i][n];
        }

        return weights;
    }

}
