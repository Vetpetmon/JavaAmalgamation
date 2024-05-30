package com.vetpetmon;

public class Main {

    public static double[][] matrix = new double[][]{
            { -1,  1,  1,  -1},
            { -1,  5,-11, -21},
            {  5, -4, -8,   0}
    };
    public static double[][] matrix2 = new double[][]{
            { 8,-1, 4,30},
            { 2, 1,-1,-3},
            {-6, 1, 2,-3}
    };

    public static void main(String[] args) {

//        Matrix.print(matrix);
//        System.out.println();
        Matrix.gaussJordan(matrix);
        System.out.println();
        Matrix.gaussJordan(matrix2);
//        System.out.println();
//        System.out.println(Matrix.correspondingDimension(matrix,matrix));
//        System.out.println();
//        double[][] m = Matrix.MAF(matrix, matrix);
//        Matrix.print(m);
    }
}