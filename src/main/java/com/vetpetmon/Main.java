package com.vetpetmon;

public class Main {

    public static double[][] matrix = new double[][]{
            { 8,-1, 4,30},
            { 2, 1,-1,-3},
            {-6, 1, 2,-3}
    };

    public static void main(String[] args) {

        System.out.println("Hello world!");

        Matrix.gaussJordan(matrix);
        System.out.println(Matrix.correspondingDimension(matrix,matrix));
        double[][] m = Matrix.MAF(matrix, matrix);
        Matrix.print(m);
    }
}