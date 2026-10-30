package org.example.linearRegression.goldPrediction;

public class Regression {

    private double[][] x;
    private double[] y;
    private MatrixMath math;
    int numberOfWeights;

    public Regression(double[][] x, double[] y, MatrixMath math ,  int numberOfWeights) {
        this.x = x;
        this.y = y;
        this.math = math;
        this.numberOfWeights = numberOfWeights;
    }

    private double[][] getGMMatrix() {
        double[][] mat = new double[x[0].length][x.length];
        for (int i = 0 ; i < x.length ; i++) {
            for (int j = 0 ; j < x[0].length ; j++) {
                mat[j][i] = x[i][j];
            }
        }
        return mat;
    }


    private double[] getRowOfFinalMatrices(int numberOfRowInResult, int numberOfWeights , double[][] mat) {

        double[] result = new double[numberOfWeights + 1];
        double yOut = math.pointMultiply(y, mat[numberOfRowInResult]);

        for (int i = 0; i < numberOfWeights; i++) {
            result[i] = math.pointMultiply(mat[i], mat[numberOfRowInResult]);
        }
        result[numberOfWeights] = yOut;
        return result;
    }

    private double[][] getFinalMatrices(int numberOfWeights) {

        double[][]  mat = getGMMatrix();

        double[][] result = new double[numberOfWeights][numberOfWeights + 1];

        for (int i = 0; i < numberOfWeights; i++) {
            result[i] = getRowOfFinalMatrices(i, numberOfWeights , mat);
        }
        return result;

    }


    public double[] getWeights() {

        double[][] matrix = getFinalMatrices(numberOfWeights);

        return math.solveGaussJordan(matrix);


    }


}
