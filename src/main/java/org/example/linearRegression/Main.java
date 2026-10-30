package org.example.linearRegression;

import org.example.linearRegression.goldPrediction.Regression;
import org.example.linearRegression.goldPrediction.MatrixMath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePath = "gld_price_only.csv";

        List<double[]> rawFeatures = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(",");
                double[] row = new double[6];
                row[0] = Double.parseDouble(String.valueOf(1));
                row[1] = Double.parseDouble(values[1]);
                row[2] = Double.parseDouble(values[2]);
                row[3] = Double.parseDouble(values[3]);
                row[4] = Double.parseDouble(values[4]);
                row[5] = Double.parseDouble(values[5]);

                rawFeatures.add(row);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن فایل. مسیر فایل را چک کن.");
            e.printStackTrace();
            return;
        }


        int numRows = rawFeatures.size() - 1;
        int numFeatures = 6;

        double[][] x = new double[numRows][numFeatures];
        double[] y = new double[numRows];

        for (int i = 0; i < numRows; i++) {
            x[i] = rawFeatures.get(i);
            y[i] = rawFeatures.get(i + 1)[4];
        }

        MatrixMath math = new MatrixMath();
        Regression regression = new Regression(x, y, math, numFeatures);

        double[] weights = regression.getWeights();


        System.out.println("--- weights ---");
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) {
                System.out.println("Bias = " + weights[i]);
            } else {
                System.out.println("w" + i + " = " + weights[i]);
            }
        }
    }
}
