package com.test;


/**
 *
 *      for i = 0 to n
 *         for j = 0 to i-1
 *           print spaces
 *         for k = 0 to n-i
 *           if star not printed
 *            print star
 *           print space
 *         for l = 0 to n-i-1
 *           if star not printed
 *            print star
 *           print space
 *
 */

public class Test_123 {
    public static void main(String[] args) {
        printPattern(5);
    }

    private static void printPattern(int input){
        boolean star = false;
        for(int i=0; i<input; i++){
            star = false;
            for(int j=0; j<input-i; j++){
                //print space
                System.out.print(" ");
            }

            for(int k=0; k<=i; k++){
                //print space
                if(!star) {
                    System.out.print("*");
                    star = true;
                }
                else {
                    System.out.print(" ");
                    star = false;
                }
            }

            for(int l=0; l<=i-1; l++){
                //print space
                if(!star) {
                    System.out.print("*");
                    star = true;
                }
                else {
                    System.out.print(" ");
                    star = false;
                }
            }
            System.out.print("\n");
        }

        for(int i=0; i<input; i++){
            star = false;
            for(int j=0; j<=i; j++){
                //print space
                System.out.print(" ");
            }

            for(int k=0; k<input-i; k++){
                //print space
                if(!star) {
                    System.out.print("*");
                    star = true;
                }
                else {
                    System.out.print(" ");
                    star = false;
                }
            }

            for(int l=0; l<input-i-1; l++){
                //print space
                if(!star) {
                    System.out.print("*");
                    star = true;
                }
                else {
                    System.out.print(" ");
                    star = false;
                }
            }
            System.out.print("\n");
        }


    }
}




