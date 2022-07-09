package com.test.dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_SubArray {
    public static void main(String[] args) {
        Arrays_SubArray as = new Arrays_SubArray();
        //as.findAllSubarrays(new int[]{1,2,3,4});
        as.sumAllSubarrayV1(new int[]{1,2,3,4});
        as.sumAllSubArrayV2(new int[] {1,2,3,4});
    }

    //Techniques
    //Contribution Technique
    //Kaden's Algorithm
    //sliding window

    /**
     * find all subarray
     */
    private void findAllSubarrays(int[] arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length ; j++) {
                s = i;
                e = j;
                ArrayList<Integer> list = new ArrayList<>();
                while(s<=e){
                    list.add(arr[s]);
                    s++;
                }
                res.add(list);
            }
        }
        System.out.println(res.toString());
    }

    /**
     * sum of all subarrays
     * TC: O(N*N)
     * prefix sum
     * sc: O(N)
     *
     */
    private void sumAllSubarrayV1(int [] arr){
        int sum = 0;
        int s = 0;
        int e = 0;

        int[] pfx = new int[arr.length];
        pfx[0] = arr[0];
        int i = 1;
        for( ; i< arr.length; i++)
            pfx[i] = pfx[i-1]+arr[i];

        for (i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length; j++) {
                s = i;
                e = j;
                if(s == 0)
                    sum += pfx[e];
                else
                    sum += pfx[e]-pfx[s-1];
            }
        }
        System.out.println(sum);
    }

    /**
     * [1,2,3,4]
     * if we see the all subarrays
     * [[1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [2], [2, 3], [2, 3, 4], [3], [3, 4], [4]]
     * we can find the contribution of each value in the sum
     * [4*1 + 6*2+ 6*3+ 4*4] = 50
     *
     * we need to find each index which can be present in which are all subarray
     * ith index will be present in (i+1) * (n-i)
     * @return
     */
    private void sumAllSubArrayV2(int [] arr){
        int i = 0;
        int N = arr.length;
        int sum = 0;
        while(i<N){
            sum += (i+1)*(N-i)*arr[i];
            i++;
        }
        System.out.println(sum);
    }


    /**
     * max sum subarray
     * when array contains negative
     *
     */


    //majority element


    //


}
