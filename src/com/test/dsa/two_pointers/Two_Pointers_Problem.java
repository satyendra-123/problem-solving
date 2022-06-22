package com.test.dsa.two_pointers;

import java.util.ArrayList;

public class Two_Pointers_Problem {
    public static void main(String[] args) {
        Two_Pointers_Problem t = new Two_Pointers_Problem();
        //t.maxArea();

    }

    /**
     * Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
     *
     * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
     *
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container.
     * 0 <= N <= 10^5
     * 1 <= A[i] <= 10^5
     */
    public int maxArea(ArrayList<Integer> A) {
        return approach1(A);
    }

    //Brute Force
    //for every container width need to check against all the vertical lines and find the max area
    //TC: O(N*N)
    //sc : O(1)

    //approach 2
    //here we have choice to move the pointers. hence we can pick at first and last end
    //when there is no choice we have only option to put at adjancent values
    //TC: O(N)
    //SC: O(1)
    private int approach1(ArrayList<Integer> A){
        if(A.size() == 0 || A.size() == 1)
            return 0;
        int i = 0;
        int j = A.size()-1;
        int max = Integer.MIN_VALUE;
        int area = 0;
        while(i < j ){
            area =   Math.min(A.get(i), A.get(j)) * (j-i);
            max = max < area ? area : max;

            if(A.get(i) < A.get(j))
                i++;
            else
                j--;
        }
        return max;
    }

}
