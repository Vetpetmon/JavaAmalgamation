package com.vetpetmon;

import java.util.Arrays;

public class Matrix {
    // TODO: Turn into object class
    /**
     * Solves a matrix using Gauss-Jordan elimination.
     * A malformed matrix with an extra column(s) in one row will
     * be safely ignored and not included in calculations.
     * @param mat Matrix to solve
     * @return The solved matrix
     */
    public static double[][] ref(double[][] mat)
    {
        int[] l= {mat.length, mat[0].length};
        double[][] ref = new double[l[0]][l[1]];

        // Work with a copy of the matrix parameter
        // We will then return this copy of the matrix
        for (int r = 0; r < l[0]; ++r)
            System.arraycopy(mat[r], 0, ref[r], 0, l[1]);

        //Loop through every row
        for (int p = 0; p < l[0]; ++p)
        {
            double pv = ref[p][p];
            // check if position is zero, if not zero, resolve.
            if (pv != 0)
            {
                double pvInv = 1.0 / pv;
                for (int i = 0; i < l[1]; ++i)
                    ref[p][i] *= pvInv;
            }
            // loop through every column in the row
            for (int r = 0; r < l[0]; ++r)
                if (r != p)
                {
                    double f = ref[r][p];
                    for (int i = 0; i < l[1]; ++i)
                        ref[r][i] -= f * ref[p][i];
                }
        }
        return ref;
    }
    // TODO: Accept float matrices and integer matrices

    /**
     * Uses REF to obtain the string results of a matrix,
     * printing the results to a log.
     * @param mat Matrix to solve and output
     */
    public static void gaussJordan(double[][]mat){
        double[][] solvedMatrix = ref(mat);
        StringBuffer matrixOut = new StringBuffer();
        int column;

        for (double[] d: solvedMatrix) {
            column=0;
            for (double d1 : d){
                column++;
                if (column>=d.length)
                    matrixOut.append("| ").append((float)d1);
                else
                    matrixOut.append((float)d1).append("\t");
            }
            System.out.println(matrixOut);
            matrixOut.delete(0,matrixOut.length());
        }
    }

    // TODO: Matrix product functions (placeholder)
    public static double[][] MPF(double[][] matrix1,double[][] matrix2) {
        double[][] mat = new double[][]{};
        return mat;
    }


    // TODO: Matrix addition functions (placeholder)
    public static double[][] MAF(double[][] matrix1,double[][] matrix2) {
        double[][] mat = new double[][]{};
        if (!correspondingDimension(matrix1,matrix2)) {
            System.out.println("Addition of the matrices given is impossible. Returning null value.");
            return null;
        }
        return mat;
    }

    public static boolean correspondingDimension(double[][]matrix1,double[][]matrix2){
        boolean flag = false;
        int[][] l= {
                {matrix1.length, matrix1[0].length},
                {matrix2.length, matrix2[0].length}
        };
        if(l[0][0]==l[1][0])
            if(l[0][1]==l[0][1])
                flag = true;
            else
                System.out.println("Matrices have differing column counts.");
        else
            System.out.println("Matrices have differing row counts.");
        return flag;
    }

    public static void print(double[][]matrix){
        if (matrix == null || Arrays.deepEquals(matrix, new double[][]{})) {
            System.out.println("Asked to print a null or empty matrix.");
            return;
        }
        StringBuffer matrixOut = new StringBuffer();
        int column;

        for (double[] d: matrix) {
            column=0;
            for (double d1 : d){
                column++;
                if (column>=d.length)
                    matrixOut.append("| ").append((float)d1);
                else
                    matrixOut.append((float)d1).append("\t");
            }
            System.out.println(matrixOut);
            matrixOut.delete(0,matrixOut.length());
        }
    }
}
