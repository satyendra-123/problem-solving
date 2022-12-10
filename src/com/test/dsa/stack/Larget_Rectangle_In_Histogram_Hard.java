package com.test.dsa.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given an array of integers A.
 *
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000000
 *  A = [2, 1, 5, 6, 2, 3]
 *  ans = 10
 */
public class Larget_Rectangle_In_Histogram_Hard {
    public static void main(String[] args) {
        Larget_Rectangle_In_Histogram_Hard lrihh = new Larget_Rectangle_In_Histogram_Hard();
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        return (int)approach1(A);
    }

    //Brute Force
    /**
     for each ith bar just find the first smaller index towards left and right.
     (s,e)
     dist = e - s - 1
     height = a[i]
     AREA = dist*height
     TC: O(N*N)
     SC: O(1)
     */

    //Approach 1
    //build NSL, NSR and find the index for each A[i]
    /**
     NSL using stack.
     NSR using stack.

     create a stack.
     create an ans array

     if NSL[i] == -1 mean we need to consider entire length [0, e] = e
     if NSR[i] == -1 mean we need to consider entire length from (s, N) = (N-s-1)
     if both are -1 mean entire N (0, N+1) = (N+1-0-1) = N
     */


    private long approach1(ArrayList<Integer> A){
        ArrayList<Integer> nsl = nslIdx(A);
        ArrayList<Integer> nsr = nsrIdx(A);

        //System.out.print(nsl);
        //System.out.print(nsr);


        long mxAr = 0;
        long area = 0;
        int N = A.size();
        int mod = 1000000007;

        for(int i=0; i<A.size(); i++){
            if(nsl.get(i) == -1 && nsr.get(i) == -1)
                area = (long)N*A.get(i);
            else if ( nsl.get(i) == -1 && nsr.get(i) != -1)
                area = (long)nsr.get(i)*A.get(i);
            else if(nsl.get(i) != -1 && nsr.get(i) == -1)
                area = (long) (N-nsl.get(i)-1) * A.get(i);
            else
                area = (long) (nsr.get(i)-nsl.get(i)-1) * A.get(i);
            mxAr = Math.max(mxAr, area);
        }

        return mxAr % mod;

    }

    private ArrayList<Integer> nslIdx(ArrayList<Integer> A){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int i = 0;
        for(; i<A.size(); i++){
            if(!st.isEmpty() && A.get(st.peek()) < A.get(i)){
                res.add(st.peek());
                st.push(i);
            }else if(st.isEmpty()){
                res.add(-1);
                st.push(i);
            }else{
                while(!st.isEmpty() && A.get(st.peek()) >= A.get(i))
                    st.pop();
                if(st.isEmpty())
                    res.add(-1);
                else
                    res.add( st.peek() );
                st.push(i);
            }
        }
        return res;
    }


    private ArrayList<Integer> nsrIdx(ArrayList<Integer> A){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int i = A.size()-1;
        for(; i>=0; i--){
            if(!st.isEmpty() && A.get(st.peek()) < A.get(i)){
                res.add(st.peek());
                st.push(i);
            }else if(st.isEmpty()){
                res.add(-1);
                st.push(i);
            }else{
                while(!st.isEmpty() && A.get(st.peek()) >= A.get(i))
                    st.pop();
                if(st.isEmpty())
                    res.add(-1);
                else
                    res.add( st.peek() );
                st.push(i);
            }
        }

        //since its build using reversal reverse the res
        i = 0;
        int j = res.size()-1;
        int temp = 0;
        while(i<j){
            temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++; j--;
        }

        return res;
    }


}
