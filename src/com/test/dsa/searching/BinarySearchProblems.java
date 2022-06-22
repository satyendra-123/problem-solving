package com.test.dsa.searching;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchProblems {
    public static void main(String[] args) {

    }

    //kth smallest element / price
    /**
     * Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).
     *
     * NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
     *
     *  A : [2 1 4 3 2]
     * k : 3
     *
     * Answer : 2
     * */
    public int solve(final List<Integer> A, int B) {
        return approach1(A, B);
    }

    //Brute Force try to sort the array and find kth element
    //TC: O(nlogn)

    //alternative approach
    //we are looking for kth element
    //kth element will lie between max and min of the array
    //find max/min in the array
    //now in the range of min to max we are looking for kth price that mean there must be at least k elements min present from mid in the array
    //it there are more elements then k which are min then definately answer mean mid should lie in right
    private int approach1(List<Integer> A, int B){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;

        while(i<A.size()){
            min = min > A.get(i) ? A.get(i) : min;
            max = max < A.get(i) ? A.get(i) : max;
            i++;
        }
        int l = min;
        int r = max;
        int mid = 0;
        int k = 0;
        int ans = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            //get min values present in array then mid
            k = countMin(A, mid);
            // System.out.print(k);
            //here we are looking for a number which has minium numbers count at least equal to k or more.
            if(k < B){
                //if count of smaller number then current mid are too less we need to move right to find more min
                l = mid+1;
            }else if( B<=k )
            {
                //if count of smaller numbers are greater then possibly we have at least k min number for this mid
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }

    private int countMin(List<Integer> A, int min){
        int count = 0;
        int i = 0;
        while(i<A.size()){
            if(A.get(i) <= min)
                count++;
            i++;
        }
        return count;
    }


    //alternative approach
    //if we can use pivot such that it partitions array in two parts and find the number which has at least k smaller
    //if left part has more smaller we can continue to partition it and find answer


    //median of matrix
    /**
     * Given a matrix of integers A of size N x M in which each row is sorted.
     *
     * Find and return the overall median of matrix A.
     *
     * NOTE: No extra memory is allowed.
     *
     * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
     */
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        return approach1(A);
    }


    //Brute Force:
    //using extra space
    //TC: O(n*m + n*mlog(n*m))
    //SC: O(n*m)


    //alternative approach
    //median is a index in. n*m size array
    // n*m/2 or median th element is 1+(n*m)/2
    /**
     if x is a median element then there will be 1+(n*m)/2 element smaller then it present in matrix

     similar to kth smallest element present in the unsorted array
     TC: O( n*m +  (n*m) * log(max(A) - min(A)) )
     SC: O(1)
     */

    private int approach1(ArrayList<ArrayList<Integer>> A){
        //search space
        int l = Integer.MAX_VALUE; //min
        int r = Integer.MIN_VALUE; //max
        int i =0;
        int j =0;
        for(; i<A.size(); i++){
            for(j=0; j<A.get(0).size(); j++){
                l = l > A.get(i).get(j) ? A.get(i).get(j) : l;
                r = r < A.get(i).get(j) ? A.get(i).get(j) : r;
            }
        }

        int n = A.size();
        int m = A.get(0).size();

        int medth_idx = 1+(n*m)/2;


        int mid = 0;
        int ans = 0;
        int cnt_smaller = 0;

        while(l <= r ){
            mid = l+(r-l)/2;
            cnt_smaller = getSmallerCount(A, mid);

            // if(cnt_smaller >= medth_idx)
            //     ans = mid;

            if(cnt_smaller < medth_idx){
                l = mid+1;
            }
            else if(cnt_smaller >= medth_idx){
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }

    private int getSmallerCount(ArrayList<ArrayList<Integer>> A, int mid){
        int c = 0;
        int i =0;
        int j =0;
        for(; i<A.size(); i++){
            for(j=0; j<A.get(0).size(); j++){
                if(A.get(i).get(j) <= mid){
                    c++;
                }
            }
        }
        return c;
    }


    //local minima / peak element


    //sqrt
    //find square root in O(logn)



}
