package com.test.dsa.searching;

import java.util.List;

/**
 * There are two sorted arrays A and B of sizes N and M respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * NOTE:
 *
 * The overall run time complexity should be O(log(m+n)).
 * IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
 *
 *1 <= N, M <= 10^6
 *  A = [1, 4, 5]
 *  B = [2, 3]
 * */
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        //m.findMedianSortedArrays();
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        return approach1(a, b);
    }

    //Brute Force
    //TC: O(n+m) put min of both in a new array and use index
    //SC: O(n+m)


    /**
     Binary Search Approach

     here we need to partition array A and pick elements by divding the array into two eaual lengths.
     once we do that we need to just make sure that we have picked the elements in sorted order

     idea: we need to pick elements from both arrays such that it satisfies condition
     A[mid-1] <= B[j] && B[j-1] <= A[mid]
     if this condition satisfies we just need to get the maximum value
     from max(A[mid-1] B[j-1]) + min(A[mid], B[j])

     if condition does not satisfies mean
     A[mid-1] > B[j] mean we need to pick lesser elements from A as its bigger then right array
     r = mid-1;

     B[j-1] > A[mid] we have pick more elements in A
     l = mid+1;

     Edge case:
     - whenever mid == 0 we need to make A[mid-1] value as INT_MIN
     - j == 0 B[j-1] INT_MIN;
     - mid == M set value as INT_MAX
     - J == N set value as INT_MAX

     if total array length is odd we can just return the max value as only first partition will contribute.

     */


    private double approach1(List<Integer> a, List<Integer> b){
        int m = a.size();
        int n = b.size();

        if(m == 0 && n == 1)
            return b.get(0)/1.0;
        else if(n == 0 && m == 1)
            return a.get(0)/1.0;
        if(m > n)
            return approach1(b, a);
        int l = 0;
        int r = m;
        int mid = 0;
        int len = (n+m+1) /2;
        int j = 0;

        int max = 0;
        int min = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            j = len - mid;

            //if mid is not in limit
            //if j is not in limit
            int left1 = mid == 0 ? Integer.MIN_VALUE : a.get(mid-1);
            int left2 = j == 0 ? Integer.MIN_VALUE : b.get(j-1);
            int right1 = mid == m ? Integer.MAX_VALUE : a.get(mid);
            int right2 = j == n ? Integer.MAX_VALUE : b.get(j);

            if(left1 <= right2 && left2 <= right1){
                //its valid
                max = Math.max(left1, left2);
                if( (n+m) % 2 == 0){
                    min = Math.min(right1, right2);
                    return (max + min)/2.0;
                }
                return max/1.0;
            }
            else if(left1 > right2){
                //need to pick less elements in left1 array
                // now A will pick less elements hence left2 will pick more elements and right2 will increase as its smaller value will move to left2
                r = mid-1;
            }else if(left2 > right1){
                //increase A and pick more elements
                //when we pick more elements in A  hence left2 will reduce
                l = mid+1;
            }
        }
        return 0.0;
    }

}
