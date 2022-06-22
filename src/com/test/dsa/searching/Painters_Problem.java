package com.test.dsa.searching;


import java.util.ArrayList;

/**
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 *
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 *
 * Return the ans % 10000003.
 *
 *
 * 1 <= A <= 1000
 * 1 <= B <= 10^6
 * 1 <= N <= 10^5
 * 1 <= C[i] <= 10^6
 *
 *  A = 10
 *  B = 1
 *  C = [1, 8, 11, 3]
 *
 * */
public class Painters_Problem {

    public static void main(String[] args) {
        Painters_Problem p = new Painters_Problem();
    }

    public int paint(int A, int B, ArrayList<Integer> C) {
        return (int)approach1(A, B, C);
    }

    //

    //Brute Force
    /**

     if we place each painter to some boards and try to see which is the min time to paint all boards it is gonna be
     O( !n * n)
     SC: O(1)
     */

    /**
     Similar to aggresive cows problem

     given A painters

     we need to find min time taken by allocated painters to paint all the boards
     such that all boards gets painted in min time

     min = when each board gets a painter mean max of boards array
     max = when only one painter to paint all boards sum of board array

     hence we need to find the time from min to max search space so we can use binary search

     here at each mid if we can get that if less then or euqal to available painters can paint all the boards in given time
     then we can reduce time and check if all boards gets painted we can keep updating our ans

     TC: O(n+n +n* log( sum - max ))
     SC: O(1)
     */

    private long approach1(int A, int B, ArrayList<Integer> C){
        long B1 = B;
        int mod = 10000003;
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int i =0;
        for(; i<C.size(); i++)
            max = max < C.get(i) ? C.get(i) : max;

        long l =  B1*max;
        i =0;
        for(; i<C.size(); i++){
            sum = sum + (B1*C.get(i));
        }

        long r = sum;
        long mid = 0;
        long ans = 0;
        long painters = 0;
        while( l <= r ){
            mid = l+(r-l)/2;

            painters = 1;
            sum = 0;
            for(i = 0; i<C.size(); i++){
                if( (sum  + (B1*C.get(i))) > mid ){
                    painters++;
                    sum =  B1*C.get(i) ;
                }else{
                    sum = sum  + (B1*C.get(i));
                }

            }
            //System.out.println(mid+" ");

            if(painters <= A){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }

        }
        return  ans%mod;
    }
}


