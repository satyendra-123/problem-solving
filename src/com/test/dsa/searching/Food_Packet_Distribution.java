package com.test.dsa.searching;

import java.util.ArrayList;

/**
 * The government wants to set up B distribution offices across N cities for the distribution of food
 * packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 106
 *q
 * 1 <= B <= 5 x 105
 *  A = [10000, 20000, 30000]
 *   B = 6
 *   ans = 100000
 */
public class Food_Packet_Distribution {

    public static void main(String[] args) {
        Food_Packet_Distribution f = new Food_Packet_Distribution();
        //f.solve()
    }


    public int solve(ArrayList<Integer> A, int B) {
        return approach1(A, B);
    }


    //Brute Force
    /**

     Answer - we want to feed as many people as we can in at least 1 office of a city

     we have N cities we need to set up B offices

     eg: 50 100 200
     B = 5
     then we can set up 1, 2, 2 and min number of pople who get food from a office remain 50 at least

     here if we find all possible combination of office set up across N cities

     [ (B+N-1) C (B)]
     no of combinations
     for each combination we need to check if the min number of people to get food are maximize

     TC: O(N * !B+N-1)
     SC: O(N)
     we need to maintain each combination no of people

     no of office required = Total Population / min_no_of_people

     */


    /**

     if we find the required no of office for n cities by giving it K min no of people
     if req >= B then our k (min people) are too low we need to increase the people to reduce the req office
     else if req < B then people size is too large we need to reduce it it can not be Answer

     a search space can have min 1 person to max (min Of N cities Population) to find the k min people
     use binary search

     */
    private int approach1(ArrayList<Integer> A, int B){
        int i = 0;

        long sum = 0;

        //[ 1, 1, 1] B = 4 we have less people then offices mean if we open all offices in all cities possible that there will be office which will not serve food to any single person hence
        //we need to check if there is such answer
        for(; i<A.size(); i++)
            sum += A.get(i);
        if(sum < B)
            return 0;

        int min = Integer.MAX_VALUE;
        i = 0;
        for( ;i<A.size(); i++)
            min = min > A.get(i) ? A.get(i) : min;

        int l = 1;
        int r = min;
        int mid = 0;
        int ofc = 0;
        int ans = 1;

        int minReqOfc = 0;
        while( l <= r){
            mid = l+(r-l)/2;
            ofc = reqOfc(A, mid);

            if(ofc >= B){
                ans = mid;
                l = mid+1;
            }else
                r = mid-1;
        }

        return ans;
    }

    private int reqOfc(ArrayList<Integer> A, int mid){
        int count = 0;
        for(int i=0; i<A.size(); i++)
            count += (A.get(i) / mid);
        return count;
    }

}


