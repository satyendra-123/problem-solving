package com.test.dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
      //  System.out.println(Arrays.toString(new int[]{1, 2, 3}));
        //System.out.println(countSlots());
        //System.out.println("000".matches("[1-9]+"));
        Matrix mat = new Matrix();
        mat.transposeAndRotate();
    }

    //find submetrices sum

    //find max submetrices sum

    //prefix sum for matrix

    //find all columsn sum for row = 0 to N-1


    //slot machine question

    private static int countSlots(){
        ArrayList<String> history = new ArrayList<>();
        history.add("137");
        history.add("364");
        history.add("115");
        history.add("724");

        int sum = 0;
        int max = 0;
        int val = 0;
        int t = history.get(0).length()-1;
        while(t >= 0){
            max = 0;
            for(int i=0; i<history.size(); i++){
                //find the max and remove
                String s = history.get(i);
                val = s.charAt(t)-'0';
                max = max < val ? val : max;
            }
            sum += max;
            t--;
        }
        return sum;
    }


    //Transpose matrix

    //rotate matrix clock wise 90 degree from top right direction as ref
    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9 10  11 12
     * 13 14 15 16
     *
     * result
     * 13  9   5  1
     * 14  10  6  2
     * 15  11  7  3
     * 16  12  8  4
     *
     */
    private void transposeAndRotate(){
        int r = 4;
        int c = 4;
        int[][] mat = createMatrix(r, c);
        //original
        System.out.println("original matrix");
        printMatrix(mat);
        int i = 1;
        int j = 0;
        int temp = 0;
        for(; i<mat.length; i++){
            for(j=0; j<i; j++){
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //transposed
        System.out.println("transposed matrix");
        printMatrix(mat);

        //reverse
        int k =0;
        for(i=0; i<mat.length; i++){
            j = 0;
            k = mat[i].length-1;
           while( j < k ){
               temp = mat[i][j];
               mat[i][j] = mat[i][k];
               mat[i][k] = temp;
               k--;
               j++;
           }
        }
        //result
        System.out.println("rotated matrix");
        printMatrix(mat);
    }

    //print diagonal matrix
    /**
     *
     */
    private void printDiagonalMatrix(){

    }

    private int[][] createMatrix(int r, int c){
        int[][] mat = new int[r][c];
        int i = 0;
        int j = 0;
        int count = 1;
        for(;i<mat.length; i++){
            for(j=0; j<mat[i].length; j++)
                mat[i][j] = count++;
        }
        return mat;
    }

    private void printMatrix(int[][] mat){
        int i =0;
        int j = 0;
        for(i=0; i<mat.length; i++){
            for(j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }
}
